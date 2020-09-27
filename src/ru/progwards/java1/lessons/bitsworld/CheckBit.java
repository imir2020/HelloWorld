package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber) {
        int result = ((value & 0b0000_0001) >> bitNumber) & 0b0000_0001;
        return result;
    }

    public static void main(String[] args) {
        CheckBit one = new CheckBit();
        System.out.println(one.checkBit((byte) 118, 0));
    }
}
