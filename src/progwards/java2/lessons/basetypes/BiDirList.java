package progwards.java2.lessons.basetypes;


import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


//Реализовать класс BiDirList - двунаправленный связный список
// Попробовать выполнить этот класс на основе OList, а затем на основе двух конструкторов.
public class BiDirList<T> implements Iterable {
    private Bi<T> head;
    private Bi<T> tail;
    private int size;

    private boolean isEmpty() {
        return head == null;
    }

    //добавить в начало списка
    public void addFirst(T item) {//Стратегия списка: LIFO
        Bi<T> first = new Bi(item);
        if (isEmpty()) {
            tail = first;
        } else {
            head.before = first;
            first.after = head;
        }
        head = first;
        size++;
    }

    //добавить в конец списка//Нужны испытания метода и его тестирования в main методе
    public void addLast(T item) {//Стратегия списка: LIFO
        Bi<T> nova = new Bi(item);
        if (isEmpty()) {
            head = nova;
        } else {
            tail.after = nova;//предыдущий экземпляр
            nova.before = tail;//новый экземпляр
        }
        tail = nova;
        size++;
    }


    public void printHead() {
        Bi temp = head;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.after;
        }
    }

    public void printTail() {
        Bi<T> temp = tail;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.before;
        }
    }

    //Ужасное исполнение задачи, но метод работает, но лучше вынести создание указателей [Bi<T> life = tail;] в отдельный метод.
    public void remove(T item) {
        Bi<T> dead = head;//что-то с этим уравнением надо сделать.
        while (size != 0) {
            if (dead == head && dead.element.equals(item)) {
                head = dead.after;
                dead.after.before = null;
                break;
            } else if (dead == tail && dead.element.equals(item)) {
                tail = dead.before;
                dead.before.after = null;
                break;
            }
            //Нужно разобраться с этой частью метода
            if (dead != null && dead.element.equals(item)) {//dead.before != null &&dead.after != null &&
                dead.after.before = dead.before;
                dead.before.after = dead.after;
                break;
            }
            if (dead != null && !dead.element.equals(item)) {
                dead = dead.after;
            } else break;
        }
        size--;//уменьшение размеров списка
    }

    //получить элемент по индексу
    public T at(int i) {
        int count1 = 1;
        int count2 = size();
        Bi temp = head;
        Bi ever = tail;
        T result = null;
        if (i > 0 && i < size() / 2) {
            while (count1 <= size()) {
                if (i == 1) {
                    result = (T) temp.element;
                    break;
                }
                temp = temp.after;
                count1++;
                if (count1 == i) {
                    result = (T) temp.element;
                    break;
                }
            }
        }
        if ((i >= size() / 2) && i <= size()) {
            while (count2 <= size()) {
                if (i == size()) {
                    result = (T) ever.element;
                    break;
                }
                ever = ever.before;
                count2--;
                if (count2 == i) {
                    result = (T) ever.element;
                    break;
                }
            }
        }
        return result;
    }

    //получить количество элементов
    public int size() {
        return size;
    }

    //конструктор из массива
    public static <T> BiDirList<T> from(T[] array) {
//Использовать к примеру метод addFirst() - в который при помощи цикла передавать элементы массива.
        BiDirList<T> list = new BiDirList<>();
        for (T element: array) {
            list.addFirst(element);
        }
        return list;
    }

    //конструктор из массива
    public static <T> BiDirList<T> of(T... array) {
//Использовать к примеру метод addFirst() - в который при помощи цикла передавать элементы массива.
        BiDirList<T> list = new BiDirList<>();
        for (T element: array) {
            list.addFirst(element);
        }
        return list;
    }

    //скопировать в массив
    public void toArray(T[] array) {
//Использовать к примеру метод printHead() - точнее код этого метода, чтобы перенести данные в массив с помощью цикла.
        BiDirList<T> list = new BiDirList<>();

    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    public static void main(String[] args) {
        //BiDirList<Integer> one = new BiDirList<>();
//        one.addFirst(37);
//        one.addFirst(78);
//        one.addFirst(68);
//        one.addFirst(17);
//        one.addFirst(54);

        // one.remove(68);

        // one.printHead();
        // System.out.println("----------------");
//        one.addLast(-95);
//        one.addLast(-54);
//        one.addLast(-56);
//        one.printHead();
//        System.out.println("----------------");
//        one.printTail();
        // one.at(0);
        // System.out.println("----------------");
        //System.out.println(one.at(2));

    }
}
