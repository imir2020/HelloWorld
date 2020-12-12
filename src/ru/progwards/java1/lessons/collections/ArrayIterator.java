package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    int lastCount;
    int count;

    ArrayIterator(T[] array) {
        this.array = array;
        lastCount = array == null ? -1 : array.length - 1;
        count = -1;
    }

    @Override
    public boolean hasNext() {
        return count < lastCount;
    }

    @Override
    public T next() {
        return array[++count];
    }

    public static void main(String[] args) {
        ArrayIterator<Integer> one = new ArrayIterator<>(new Integer[]{2, 1, 3});
        while (one.hasNext()) System.out.println(one.next());
    }
}
