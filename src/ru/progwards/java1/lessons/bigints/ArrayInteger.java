package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ArrayInteger {
    private Byte[] digits;
    int putVal;

    public ArrayInteger(int n) {
        putVal = 0;
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

        for (int i = 0; i < res / 2; i++) {
            byte temp = digits[i];
            digits[i] = digits[res - 1 - i];
            digits[res - 1 - i] = temp;
        }
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
        int row;
        if (this.digits.length > num.digits.length) {
            row = this.digits.length + 1;
        } else {
            row = num.digits.length + 1;
        }
        for (int i = row; i > 0; i--) {
            Byte temp1 = digits[i];
            Byte temp2 = num.digits[i];
            //temp1 += temp2;
        }
        return false;//заглушка
    }

    public static void main(String[] args) {
        ArrayInteger one = new ArrayInteger(67);
        one.fromInt(new BigInteger("48"));
        // one.toInt();
        System.out.println(one.toInt());

    }
}
