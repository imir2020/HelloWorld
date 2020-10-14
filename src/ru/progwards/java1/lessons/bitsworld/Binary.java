package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 7; i >= 0; i--) {
            result += CheckBit.checkBit(num, i);
        }
        return result;
    }

    public static void main(String[] args) {
        Binary one = new Binary((byte) 2);
        System.out.println(one.toString());
    }
}
