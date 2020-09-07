package ru.progwards.java1.lessons.arrays;

public class ArraySort {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArraySort one = new ArraySort();
        int[] b = new int[]{12, 43, -13, 54, 684, -42, 0, 1, 56, 93};
        one.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}

