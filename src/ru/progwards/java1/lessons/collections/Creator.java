package ru.progwards.java1.lessons.collections;


import java.util.*;

public class Creator {
    public static Collection<Integer> fillEven(int n) {
        List<Integer> evenNumbersList = new ArrayList();
        final int EVEN_NUMBER = 2;
        final int FIRST_NUMBER = 1;
        for (int i = FIRST_NUMBER; i < n; i++) {
            evenNumbersList.add(EVEN_NUMBER * i);
        }
        return evenNumbersList;
    }

    public static Collection<Integer> fillOdd(int n) {
        List<Integer> oddNumbersList = new ArrayList();
        final int ODD_NUMBER = 3;
        final int LAST_NUMBER = 1;
        for (int i = n; i >= LAST_NUMBER; i--) {
            if (i%2 != 0) {
                oddNumbersList.add(ODD_NUMBER * i);
            }
        }
        return oddNumbersList;
    }

    public static Collection<Integer> fill3(int n) {
        List<Integer> tripleNumbersList = new ArrayList();
        final int FIRST_NUMBER = 1;
        for (int i = FIRST_NUMBER; i < n; i++) {
            tripleNumbersList.add(i);
                    tripleNumbersList.add(i*i);
            tripleNumbersList.add(i*i*i);
        }
        return tripleNumbersList;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(90));
        System.out.println(fillOdd(90));
        System.out.println( fill3(90));
    }
}
