package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        int temp = (byte) (num&0b0000_0001);
        //String temp = Integer.toBinaryString(num);
        return num + ": " + temp;
    }
    public String toStringSecond() {
        //произвести перевод числа из десятичного счисления в двоичное.
        for (int i = 0; i < 8; i++) {

        }
        return num + ": ";
    }

    public static void main(String[] args) {
        Binary one = new Binary((byte) 6);
        System.out.println(one.toString());
    }
}
