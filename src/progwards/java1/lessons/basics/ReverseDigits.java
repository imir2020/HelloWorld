package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number) {
        int result = (number%10)*100 + ((number/10)%10)*10 + number/100;
        return result;
    }

    public static void main(String[] args) {
        ReverseDigits one = new ReverseDigits();
        System.out.println(one.reverseDigits(379));
    }
}
