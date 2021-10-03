package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {
    public static void sort(CompareWeight[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[i + 1]) == CompareWeight.CompareResult.GREATER) {
                    CompareWeight  temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArraySort one = new ArraySort();
        CompareWeight[] a = new CompareWeight[]{new Animal(0), new Cow(43), new Hamster(89),
               new Duck(75)};
        one.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

