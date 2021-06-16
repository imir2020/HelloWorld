package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//Реализовать класс BiDirList - двунаправленный связный список
// Попробовать выполнить этот класс на основе OList, а затем на основе двух конструкторов.
public class BiDirList<T> implements Iterable {
    private Bi<T> head;
    private Bi<T> tail;

    private boolean isEmpty() {
        return head == null;
    }

    //добавить в конец списка
    public void addLast(T item) {//Стратегия списка: LIFO
        Bi<T> second = new Bi<>(item);
        if (isEmpty()) {
            head = second;
        } else {
            tail.after = second;
        }
        second.before = tail;
        tail = second;
    }

    //добавить в начало списка
    public void addFirst(T item) {//Стратегия списка: LIFO
        Bi<T> first = new Bi<>(item);
        if (isEmpty()) {
            tail = first;
        } else {
            head.before = first;
        }
        first.after = head;
        head = first;
    }

    public void printHead() {
        Bi<T> temp = head;
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

    //удалить//Нужно создать методы, удаляющие хвост и голову списка, и использовать их здесь.
    public void remove(T item) {
        Bi<T> temp = head;
        while (temp.after != null) {
            if (temp.element == null) return;
            if (temp.element.equals(item)) {
                temp.after.before = null;
            }
            temp = temp.after;
        }

    }

    //получить элемент по индексу
    public T at(int i) {

        return null;
    }

    //получить количество элементов
    public int size() {

        return 0;
    }

    //конструктор из массива
    public static <T> BiDirList<T> from(T[] array) {

        return null;
    }

    //конструктор из массива
    public static <T> BiDirList<T> of(T... array) {

        return null;
    }

    //скопировать в массив
    public void toArray(T[] array) {

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
        BiDirList<Integer> one = new BiDirList<>();
        one.addFirst(3737);
        one.addFirst(578);
        one.addFirst(68);
        one.addFirst(178);

        //one.addLast(-95);
        //one.addLast(-54);
        // one.addLast(-56);
        one.printHead();
        System.out.println("----------------");
        //one.printTail();
//        OList<Integer> list = new OList<>();
//        list.add(8957);
//        list.add(976);
//        list.add(365);
//        OList<Integer>.ListItem<Integer> current = list.getHead();
//        while (current != null){
//            System.out.println(current.getItem());
//            current = current.getNext();
//        }
    }
}
