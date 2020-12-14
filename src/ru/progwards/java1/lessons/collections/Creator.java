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

//    public static Collection<Integer> fillOdd(int n) {
//        int firstOddNumbers = n * 2 - 1;
//        Collection<Integer> oddNumbersList = new ArrayList<>();
//        for (int i = n; i > 0; i-- ){
//            firstOddNumbers -= 2;
//            oddNumbersList.add(firstOddNumbers);
//        }
//
//        return oddNumbersList;
//    }
    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> oddNumbersList = new ArrayList<>();
        for (int i = n; i > 0 ; i-- ){
           int firstOddNumbers = i * 2 - 1;
            oddNumbersList.add(firstOddNumbers);
        }
        return oddNumbersList;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> tripleNumbersList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tripleNumbersList.add(i);
            tripleNumbersList.add(i*i);
            tripleNumbersList.add(i*i*i);
        }
        return tripleNumbersList;
    }

    public static void main(String[] args) {
       // System.out.println(fillEven(90));
       // System.out.println(fillOdd(19));
        System.out.println( fill3(3));
    }
}
