package ru.progwards.java1.lessons.bigints;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class IntInteger  extends  AbsInteger{//
    int three;

    public IntInteger(int three) {
        super();
        this.three = three;
    }

    @Override
    public String toString() {
        String str = String.valueOf(this.three);
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
        IntInteger third = new IntInteger(585);
        System.out.println(third.toString());
    }
}
