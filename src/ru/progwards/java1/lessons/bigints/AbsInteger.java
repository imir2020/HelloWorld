package ru.progwards.java1.lessons.bigints;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;


public class AbsInteger {
    String string;

    public AbsInteger(String string) {
        this.string = string;
    }

    public AbsInteger() {
    }

    @Override
    public String toString() {
        return string;
    }


    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
       int result = num1.getValue() + num2.getValue();
        AbsInteger temp = new AbsInteger(String.valueOf(result));
        return temp;
    }

    private int getValue() {
        return Integer.parseInt(toString());
    }

    public static void main(String[] args) {
        AbsInteger one = new AbsInteger("123");
        AbsInteger two = new AbsInteger("446");
        ShortInteger second = new ShortInteger((short) 84);
        ShortInteger first = new ShortInteger((short) 93);
        IntInteger third = new IntInteger(585);
        IntInteger fourth = new IntInteger(-723);
        ByteInteger past = new ByteInteger((byte) 23);
        System.out.println(one.add(one, two));
        System.out.println();
        System.out.println(one.add(second, third));
        System.out.println();
        System.out.println(one.add(past, fourth));
    }
}
