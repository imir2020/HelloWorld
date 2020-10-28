package ru.progwards.java1.lessons.bigints;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

// Главная идея в следующем - сначала ввести в метод число, под видом строки, затем с помощью BigInteger
// перевести число в строке в число, а затем, в классах наследниках, извлекать из BigInteger это число в нужный формат(для этого
//есть методы в классе BigInteger.
public class AbsInteger {
    String str;

    public AbsInteger(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

    // В этом методе,  не передаются объекты.
    @NotNull
    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        BigInteger res1 = new BigInteger(num1.toString());//
        BigInteger res2 = new BigInteger(num2.toString());
        BigInteger res3 = res1.add(res2);
        AbsInteger temp = new AbsInteger(String.valueOf(res3));

        return temp;
    }

    public static void main(String[] args) {
        AbsInteger one = new AbsInteger("123");
        AbsInteger two = new AbsInteger("456");
        System.out.println(one.add(one, two));
    }
}
