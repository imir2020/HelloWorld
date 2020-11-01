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

    public static void main(String[] args) {
        IntInteger third = new IntInteger(585);
        System.out.println(third.toString());
    }
}
