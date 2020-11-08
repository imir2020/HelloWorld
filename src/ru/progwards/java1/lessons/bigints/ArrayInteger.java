package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;


public class ArrayInteger {
    private Byte[] digits;

    public ArrayInteger(int n) {
        digits = new Byte[n];
    }

    void fromInt(BigInteger value) {
        String str = value.toString();
        int res = str.length();
        digits = new Byte[res];
        for (int i = 0; i < res; i++) {
            if (!value.equals(BigInteger.ZERO)) {
                digits[i] = value.mod(BigInteger.TEN).byteValueExact();
            }
            value = value.divide(BigInteger.TEN);
        }
//Реверс массива
//        for (int i = 0; i < res / 2; i++) {
//            byte temp = digits[i];
//            digits[i] = digits[res - 1 - i];
//            digits[res - 1 - i] = temp;
//        }
    }

    BigInteger toInt() {
        String string;
        String result = "";
        for (int i = 0; i < digits.length; i++) {
            string = String.valueOf(digits[i]);
            result = result + string;
        }
        return new BigInteger(result);
    }

    boolean add(ArrayInteger num) {
        final int BASE = 10;
        int row;
        boolean maxInt = true;
        if (digits.length >= num.digits.length) {
            row = num.digits.length;

            for (int i = 0; i < row; i++) {

                digits[i] = (byte) (digits[i] + num.digits[i]);

                System.out.println(digits[i]);
            }

        } else {

            row = digits.length;

            for (int i = 0; i < row; i++) {
                num.digits[i] = (byte) (digits[i] + num.digits[i]);
            }
            digits = Arrays.copyOf(digits, num.digits.length);
        }
        for (int i = 0; i < row - 1; i++) {
            if (digits[i] >= BASE) {
                digits[i] = (byte) (digits[i] - BASE);
                digits[i + 1]++;
            }
        }
        //test
        for (int i = 0; i < row; i++) {
            if (digits[i] > 9) {
                maxInt = false;
                for (int j = 0; j < row; j++) {
                    digits[j] = 0;
                }
            }
            //System.out.print(digits[i]);//test// + " 2 "
        }
        //System.out.println();//test
        return maxInt;
    }

    public static void main(String[] args) {
        ArrayInteger one = new ArrayInteger(3);
        ArrayInteger two = new ArrayInteger(3);
        one.fromInt(new BigInteger("31"));
        two.fromInt(new BigInteger("9"));
        one.toInt();
        //System.out.println(one.toInt());
        System.out.println(one.add(two));
    }
}
