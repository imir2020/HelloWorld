package ru.progwards.java1.lessons.collections;


import java.util.*;

public class Creator {
    public static Collection<Integer> fillEven(int n) {
        int evenNumber = 2;
        Collection<Integer> evenNumbersList = new ArrayList<>();
        for (int i = n; i > 0; i--){
            evenNumber += 2;
            evenNumbersList.add(evenNumber);
        }
        return evenNumbersList;
    }

    public static Collection<Integer> fillOdd(int n) {
        int oddNumbers = n * 2 - 1;
        Collection<Integer> oddNumbersList = new ArrayList<>();
        for (int i = n; i > 0; i-- ){
            oddNumbers -= 2;
            oddNumbersList.add(oddNumbers);
        }

        return oddNumbersList;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> tripleNumbersList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            switch (i % 3) {
                case 0:
                    tripleNumbersList.add(i);
                    break;
                case 1:
                    tripleNumbersList.add(i * i);
                    break;
                case 2:
                    tripleNumbersList.add(i * i * i);
                    break;
            }
        }
        return tripleNumbersList;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(90));
        System.out.println(fillOdd(90));
        System.out.println( fill3(90));
    }
}
