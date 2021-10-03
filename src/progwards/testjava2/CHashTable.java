package progwards.testjava2;

public class CHashTable<T> {

    class CHashItem<T> {
        private T item;
        private int key;
        private CHashItem<T> next;

        CHashItem(int key, T item) {
            this.item = item;
            this.key = key;
        }

        int getKey() {
            return key;
        }

        T getItem() {
            return item;
        }

        void setNext(CHashItem<T> nova) {
            next = nova;
        }

        CHashItem<T> getNext() {
            return next;
        }
    }

    CHashItem<T>[] table;

    CHashTable(int n) {// n  - что это и откуда?
        table = new CHashItem[n];
    }

    public int getHash(int key) {
        return key % table.length;
    }

    void add(int key, T item) {
        int index = getHash(key);
        //Разобраться с работой указателей в этом методе.
        CHashItem<T> li = new CHashItem<>(key, item);
        CHashItem<T> head = table[index];//head - Это временная переменная, куда загружается содержимое ячейки массива table[index]
        table[index] = li;// Если table[index] равен null, то в ячейку добавляется ссылка li на экземпляр класса new CHashItem<>(key, item)
        if (head != null) {// Если table[index]  уже занят, тогда срабатывает условие if (head != null), и в данной ячейке появляется односвязный список.
            li.setNext(head);//Связанные строки кода
        }
    }

    T get(int key) {
        int index = getHash(key);
        CHashItem<T> current = table[index];
        do {
            if (current.key == key)
                return current.getItem();
            current = current.getNext();//Связанные строки кода
        } while (current != null);
        return null;
    }

    public static void main(String[] args) {
        CHashTable<String> table = new CHashTable<>(10);
        for (int i = 0; i < 100; i++) {
            table.add(i, "i = " + i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(table.get(i));
        }
    }
}
