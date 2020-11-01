package ru.progwards.java1.lessons.bigints;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class ShortInteger  extends  AbsInteger{
    short two;

    public ShortInteger(short two) {
        super();
        this.two = two;
    }

    @Override
    public String toString() {
        String str = String.valueOf(this.two);
        return str;
    }

    public static void main(String[] args) {
        ShortInteger second = new ShortInteger((short) 84);
        ShortInteger first = new ShortInteger((short) 93);
        AbsInteger one = new AbsInteger();
        System.out.println(one.add(first, second));//Кажется получилось:)
    }
}
