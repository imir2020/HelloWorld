package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

/*
Сделать итератор MatrixIterator по двумерному массиву (матрице), который разворачивает матрицу в
 линейную последовательность построчно: a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]

Шаблон для итератора взять от ArrayIterator
 */
public class MatrixIterator<T> implements Iterator<T> {
    private T[][] list;
    int len;
    int count;
    int nextIdx;
    ArrayIterator<T> iterator;
    ArrayIterator<T> nextIterator;

    MatrixIterator(T[][] array) {
        this.list = array;
        len = array == null ? -1 : array.length;
        count = -1;
        calcNextIterator();
        iterator = nextIterator;
        count = nextIdx;
    }

    void calcNextIterator() {
        int i = count + 1;
        while (i < len) {
            if (list[i] != null && list[i].length > 0) {
                nextIterator = new ArrayIterator<>(list[i]);
                nextIdx = i;
                return;
            }
            i++;
        }
        nextIterator = null;
    }

    @Override
    public boolean hasNext() {
        return nextIterator != null;
    }

    @Override
    public T next() {
        if (!iterator.hasNext()) {
            count = nextIdx;
            iterator = nextIterator;
        }
        T result = iterator.next();
        if (!iterator.hasNext()) calcNextIterator();
        return result;
    }
    public static void main(String[] args) {
        MatrixIterator<Integer> one = new MatrixIterator<>(new Integer[][]{null, new Integer[]{12, 35}, null});
        while (one.hasNext()) System.out.println(one.next());
    }
}
