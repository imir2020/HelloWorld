package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends  AbsInteger {
    short two;

    public ShortInteger(short two) {
        this.two = two;
    }

    @Override
    public String toString() {
        String str = String.valueOf(this.two);
        return str;
    }

    public static void main(String[] args) {
        ShortInteger second = new ShortInteger((short) 84);
        System.out.println(second.toString());
    }
}
