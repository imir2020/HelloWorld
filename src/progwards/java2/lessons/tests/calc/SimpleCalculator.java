package ru.progwards.java2.lessons.tests.calc;


public class SimpleCalculator {
    public int sum(int val1, int val2) throws ArithmeticException {
        long res = (long) val1 + val2;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) throw new ArithmeticException("ERROR!!!");
        return val1 + val2;
    }

    public int diff(int val1, int val2) throws ArithmeticException {
        long res = (long) val1 - val2;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) throw new ArithmeticException("ERROR!!!");
        return val1 - val2;
    }

    public int mult(int val1, int val2) throws ArithmeticException {
        long res = (long) val1 * val2;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) throw new ArithmeticException("ERROR!!!");
        return val1 * val2;
    }

    public int div(int val1, int val2) throws ArithmeticException {
        if (val2 == 0) throw new ArithmeticException("ERROR!!!");
        return val1 / val2;
    }

    public static void main(String[] args) {
        SimpleCalculator one = new SimpleCalculator();
        // System.out.println(one.sum(7, 7));
        // System.out.println(one.diff(9, 5));
        //System.out.println(one.mult(5, 7));
        System.out.println(one.div(0, 1));
    }
}
