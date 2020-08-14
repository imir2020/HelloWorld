package ru.progwards.java1.lessons.compare_if_cycles;

public class TrianglesSimpleInfo {
    public static int maxSide(int a, int b, int c) {
        int result = 0;
        if (a > c && a > b) {
            result = a;
        }
        if (b > a && b > c) {
            result = b;
        }
        if (c > a && c > b) {
            result = c;
        }
        return result;
    }

    public static int minSide(int a, int b, int c) {
        int result = 0;
        if (a < c && a < b) {
            result = a;
        }
        if (b < a && b < c) {
            result = b;
        }
        if (c < a && c < b) {
            result = c;
        }
        return result;
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        int result = a - b - c;
        boolean finish;
        if (result == 0) {
            finish = true;
        } else {
            finish = false;
        }
        return finish;
    }

    public static void main(String[] args) {
        TrianglesSimpleInfo one = new TrianglesSimpleInfo();
        one.maxSide(2, 4, 8);
        one.minSide(2, 4, 5);
        one.isEquilateralTriangle(4, 1, 9);
    }
}
