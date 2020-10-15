package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo = new CacheInfo();

    public static int fiboNumber(int n) {
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

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;
    }

    public static void main(String[] args) {
        CalculateFibonacci one = new CalculateFibonacci();
        one.fiboNumber(13);
        one.fiboNumber(10);
        System.out.println( one.fiboNumber(13));
        System.out.println( one.fiboNumber(12));
    }
}
