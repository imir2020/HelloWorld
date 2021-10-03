package progwards.java2.lessons.basetypes;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class DoubleHashTable<K, V> implements Iterable, HashValue<K> {
    private int startSize = 101;
    /*
    Интересно, а если сделать массив зранения двумерным, двустрочным, и в одной ячейку хранить память, а в ячейке напротив флаг?
     */
    //Стратегия роста массива - удвоение размеров, при количестве пробирований равном 10.
    // Соответственно нужно почитать про размер шагов при пробировании при стратегии роста массива - удвоение.
    private DataItem[] array;
    private static final double A = 0.6180339887;
    private int countEfforts = 0;
    private static final int LIMIT = 10;

    //В этом конструкторе, создать экземпляр специального конструктора из класса DataItem, который бы показывал флаг стертой ячейки.
    public DoubleHashTable() {
        array = new DataItem[startSize];
        if (countEfforts == LIMIT)
            array = new DataItem[2 * startSize];//Возможно это придётся перенести в метод add или в отдельный метод.
        //Либо флаг другом конструкторе, либо привязка к текущему экземпляру new DataItem<>(key, value), либо чтото третье.
    }

    //добавить пару ключ-значение
    public void add(K key, V value) {
        if (value == null) new NullPointerException();
        int index = getHash(key);
        DataItem<K, V> one = new DataItem<>(key, value);
        while (array[index] != null && array[index].getFlag() != -1) { //Нужен флаг удалённой ячейки. Текущий экземпляр в ячейке не имеет флага и не может иметь.
            index += getStep(key);
            index %= array.length;//Задаёт смещение к началу отсчёта.
            countEfforts++;
        }
        reHash(key);
        array[index] = one;
        System.out.println(countEfforts);
    }

    //В случае переполнения  расширенного массива метод снова вызывает себя - рекурсия.
    public void reHash(K key) {
        if (countEfforts == LIMIT) {
            //Скопировать старую таблицу, с перерасчётом хэшей относительно новых размеров таблицы, обнулить переменную countEfforts,
            // и продолжить попытки записи нового элемента, но уже в новый массив.
            //reHash()
            countEfforts = 0;
            DataItem[] tempArray = new DataItem[size()];
            //нужно скопировать во временный массив только настоящие элементы
            for (DataItem s : array) {
                int i = 0;
                if (array[i] != null && array[i].getFlag() != -1) {
                    tempArray[i] = s;
                    i++;
                }
            }
            array = new DataItem[2 * startSize];
            int index = getHash(key);
            for (int i = 0; i < tempArray.length; i++) {
                while (array[index] != null && array[index].getFlag() != -1) {
                    index += getStep(key);
                    index %= array.length;//Задаёт смещение к началу отсчёта.
                    countEfforts++;
                }
                array[index] = tempArray[i];
            }
            if (countEfforts == LIMIT) reHash(key);

        }
    }

    //- получить значение по ключу
    //Данный поиск должен ограничиваться размером таблицы
    public V get(K key) {
        int index = getHash(key);
        while (array[index] != null || array[index].getFlag() != -1) { //Нужен флаг удалённой ячейки. Уже есть.
            if (array[index].getKey() == key) {
                return (V) array[index].getValue();
            }
            index += getStep(key);
            index %= array.length;//Задаёт смещение к началу отсчёта.
        }
        return null;//элемент не найден
    }

    //- удалить элемент по ключу
    public void remove(K key) {
        int index = getHash(key);
        int step = getStep(key);
        while (array[index] != null && array[index].getFlag() != -1) { //Нужен флаг удалённой ячейки. Уже есть.
            if (array[index].getKey() == key) {
                // array[index].setValue(null);//Возможно достаточно флага.
                array[index].setFlag();
                break;
            }
            index += step;
            index %= array.length;//Задаёт смещение к началу отсчёта.
        }
    }

    //- изменить значение ключа у элемента с key1 на key2
    // нужно тестировать
    public void change(K key1, K key2) {
        int index = getHash(key1);
        int indexNext = getHash(key2);
        int step = getStep(key2);
        DataItem temp = null;
        while (array[index] != null && array[index].getFlag() != -1) { //Нужен флаг удалённой ячейки. Уже есть.
            if (array[index].getKey() == key1) {
                array[index].setKey(key2);
                temp = array[index];
                break;
            }
            index += step;
            index %= array.length;//Задаёт смещение к началу отсчёта.
        }
        while (array[indexNext] != null && array[indexNext].getFlag() == -1) {
            if (array[indexNext] == null) {
                array[indexNext] = temp;
                array[index].setFlag();
                break;
            }
            indexNext += step;
            indexNext %= array.length;//Задаёт смещение к началу отсчёта.
        }
    }

    //- получить количество элементов в таблице
    public int size() {
        int countElements = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getFlag() != -1) countElements++;
        }
        return countElements;
    }

    //Посмотреть официальную документацию, затем примеры реализации в интернете.
    //Смотреть лекцию на курсе.
    @NotNull
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Object next() {
                return array[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Objects.requireNonNull(action);
        for (Object t : this) {
            action.accept(t);
        }
    }

    @Override
    public Spliterator spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
//        return new Spliterator() {
//
//            @Override
//            public boolean tryAdvance(Consumer action) {
//                return false;
//            }
//
//            @Override
//            public Spliterator trySplit() {
//                return null;
//            }
//
//            @Override
//            public long estimateSize() {
//                return array.length;
//            }
//
//            @Override
//            public int characteristics() {
//                return SIZED;
//            }
//        };
    }

    @Override
    public int getHash(K key) {
        String buff = String.valueOf(key);
        char temp = 0;
        for (int i = 0; i < buff.length(); i++) {
            temp += buff.charAt(i);
        }
        double f = A * temp;
        return (int) (array.length * (f - Math.floor(f)));
    }

    private int getStep(K key) {
        String buff = String.valueOf(key);
        char temp = 0;
        for (int i = 0; i < buff.length(); i++) {
            temp += buff.charAt(i);
        }
        // System.out.println((int)temp);
        //System.out.println(3 - temp % array.length);
        return 3 - temp % array.length;
    }

    //Нужны тесты с переполнением массива таблицы.
    public static void main(String[] args) {
        DoubleHashTable<Integer, String> one = new DoubleHashTable<>();
        one.add(23, "what");
        one.add(23, "wha");
        one.add(23, "wht");
        //one.add(23, "what");
    }
}
