package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        int result = ((value >> bitNumber) & 1);
        return result;
    }

    public static void main(String[] args) {
        CheckBit one = new CheckBit();
        System.out.println(one.checkBit((byte) 118, 0));
    }
}
