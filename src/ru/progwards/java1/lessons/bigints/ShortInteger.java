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
    @NotNull
    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        BigInteger res1 = new BigInteger(num1.toString());//
        BigInteger res2 = new BigInteger(num2.toString());
        BigInteger res3 = res1.add(res2);
        AbsInteger temp = new AbsInteger(String.valueOf(res3));
        return temp;
    }
    public static void main(String[] args) {
        ShortInteger second = new ShortInteger((short) 84);
        ShortInteger first = new ShortInteger((short) 93);
        AbsInteger one = new AbsInteger();
        System.out.println(one.add(first, second));//Кажется получилось:)
    }
}
