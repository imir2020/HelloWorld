package ru.progwards.java1.lessons.interfaces;

import org.w3c.dom.ls.LSOutput;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {
        lastFibo = new CacheInfo();
        int fibo = 1;
        int previousNumber = 0;
        int nextNumber = 1;
        if (n != lastFibo.n) {
            for (int i = 1; i < n; i++) {
                fibo = previousNumber + nextNumber;
                previousNumber = nextNumber;
                nextNumber = fibo;
                lastFibo.fibo = nextNumber;
                lastFibo.n = n;
            }
        } else {
            fibo = lastFibo.fibo;
        }
        return fibo;
    }

    //Разобраться как работает этот метод, и исправить его.
    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    //Разобраться как работает этот метод, и исправить его.
    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;
    }

    public static void main(String[] args) {
        CalculateFibonacci one = new CalculateFibonacci();
        one.fiboNumber(1);
        System.out.println( one.fiboNumber(11));
        System.out.println( one.getLastFibo());
        System.out.println(getLastFibo().n);
        System.out.println(getLastFibo().fibo);
        one.clearLastFibo();

    }
}
