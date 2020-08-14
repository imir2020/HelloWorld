package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        boolean finish;
        if (a < (b + c) && b < (a + c) && c < (a + b)) {
            finish = true;
        } else {
            finish = false;
        }
        return finish;
    }

    public static boolean isRightTriangle(int a, int b, int c) {

        boolean bigLine;
        if (a * a == (b * b + c * c)) {
            bigLine = true;
        } else if (b * b == (a * a + c * c)) {
            bigLine = true;
        } else if (c * c == (b * b + a * a)) {
            bigLine = true;
        } else {
            bigLine = false;
        }
        return bigLine;
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        boolean result;
        if (a == b || b == c || c == a){
            result = true;
        } else{
            result = false;
        }
        return  result;
    }
}
