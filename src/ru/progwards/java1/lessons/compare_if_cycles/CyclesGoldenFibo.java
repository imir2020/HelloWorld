package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static boolean containsDigit(int number, int digit) {
        boolean result = false;
        if(number == 0 && digit == 0){
            return false;
        }
        while (number > 0) {
            if (number % 10 == digit) {
                result = true;
                break;
            } else {
                result = false;
            }
            number = number / 10;
        }
        return result;
    }

    public static int fiboNumber(int n) {
        int sum = 1;
        int previousNumber = 0;
        int nextNumber = 1;
        for (int i = 1; i < n; i++) {
            sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        return sum;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        double result = 0;
        boolean response;
        if (a == b) {
            result = (double) a / c;
        }
        if (b == c) {
            result = (double) b / a;
        }
        if (a == c) {
            result = (double) a / b;
        }
        if (1.61703 <= result && result <= 1.61903) {
            response = true;
        } else {
            response = false;
        }
        return response;
    }

    public static void main(String[] args) {
        CyclesGoldenFibo one = new CyclesGoldenFibo();
        System.out.println(one.fiboNumber(2));
        System.out.println(one.containsDigit(98776, 5));
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.println(one.fiboNumber(i));
        }
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (one.isGoldenTriangle(i, i, j)) {
                    System.out.println(j + " " + i);
                }
            }
        }
    }
}
