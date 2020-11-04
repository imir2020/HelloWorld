package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    String string;

    public AbsInteger(String string) {
        this.string = string;
    }

    public AbsInteger() {
    }

    @Override
    public String toString() {
        return string;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        AbsInteger temp = null;
        int result = num1.getValue() + num2.getValue();
        if (result >= Byte.MIN_VALUE && result <=Byte.MAX_VALUE) {
            temp = new ByteInteger((byte) result);
            System.out.println(temp.toString());
        } else if ((result >= Short.MIN_VALUE && result < Byte.MIN_VALUE) || (result <= Short.MAX_VALUE && result > Byte.MAX_VALUE)) {
            temp = new ShortInteger((short) result);
        } else if ((result >= Integer.MIN_VALUE && result < Short.MIN_VALUE) || (result <= Integer.MAX_VALUE && result > Short.MAX_VALUE)) {
            temp = new IntInteger(result);
        }
        return temp;
    }

    private int getValue() {
        return Integer.parseInt(toString());
    }

    public static void main(String[] args) {
        AbsInteger one = new AbsInteger("123");
        System.out.println(one.add(new ByteInteger((byte) - 2), new ShortInteger((short) 1099)));
    }
}
