package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//Реализовать класс DoubleHashTable - хэш таблица с двойным хэшированием

public class DoubleHashTable<K, V> implements HashValue, Iterable {

    public void add(K key, V value) {

    }

    public V get(K key) {

        return null;
    }

    public void remove(K key) {

    }

    public void change(K key1, K key2) {

    }

    public int size() {

        return 0;
    }


    @Override
    public int getHash() {

        return 0;
    }

    public static void main(String[] args) {

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
}
