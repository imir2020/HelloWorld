package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num) {
        this.num = num;

    }

    @Override
    public String toString() {
        return num + " : " + Integer.toBinaryString(num);
    }

    public static void main(String[] args) {
        Binary one = new Binary((byte) 18);
        System.out.println(one.toString());
    }
}
