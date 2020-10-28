package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ByteInteger  {//extends  AbsInteger

    byte one;

    public ByteInteger(byte one) {

        this.one = one;
    }

    @Override
    public String toString() {
        String str = String.valueOf(this.one);
        return str;
    }


    public static void main(String[] args) {
        ByteInteger first = new ByteInteger((byte) 23);

        System.out.println(first.toString());
    }
}
