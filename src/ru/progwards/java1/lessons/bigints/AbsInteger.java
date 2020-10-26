package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
// Главная идея в следующем - сначала ввести в метод число, под видом строки, затем с помощью BigInteger
// перевести число в строке в число, а затем, в классах наследниках, извлекать из BigInteger это число в нужный формат(для этого
//есть методы в классе BigInteger.
public class AbsInteger {
String str;


    public AbsInteger(String str) {
        this.str = str;
    }

    //Нужны методы , возвращающие число от экземпляра класса.
    static String someInt1(AbsInteger num1){
        return num1.str;
    }
    static String someInt2(AbsInteger num2){
        return num2.str;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {

        BigInteger res1 = new BigInteger(String.valueOf(num1.someInt1));
        BigInteger res2 = new BigInteger(String.valueOf(num2));
        BigInteger res3 = res1.add(res2);
       // BigInteger res1
        return null;
    }

    public static void main(String[] args) {
        AbsInteger one = new AbsInteger("123");
        AbsInteger two = new AbsInteger("456");
        System.out.println(one.add(one, two));
    }
}
