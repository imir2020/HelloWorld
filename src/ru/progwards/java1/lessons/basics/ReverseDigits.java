package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
        ReverseDigits one = new ReverseDigits();
        one.reverseDigits(846);
        System.out.println(one.reverseDigits(846));
    }

    public static int reverseDigits(int number) {
        int result1 = (number%10)*100 + ((number/10)%10)*10 + number/100;
        return result1;
    }

}
