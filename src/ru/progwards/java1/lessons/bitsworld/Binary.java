package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num + " : " + String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    public static void main(String[] args) {
        Binary one = new Binary((byte) 0);
        System.out.println(one.toString());
    }
}
