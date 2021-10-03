package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    private static final String[] matrix = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final int numberPhoneLength = 11;
    private final static String firstNumberPhoneCode = "+7";
    private final static String errorFirstNumber = "8";

    //первый вариант решения.
    public static String format1(String phone) {
        String[] phoneNumbers = new String[phone.length()];
        StringBuilder cleanPhoneNumber = new StringBuilder();
        int count = 0;
        for (int i = 0; i < phone.length(); i++) {
            phoneNumbers[i] = String.valueOf(phone.charAt(i));
            for (int j = 0; j < matrix.length; j++) {
                if (phoneNumbers[i].equals(matrix[j])) {
                    if (phoneNumbers[0].equals(errorFirstNumber)) {
                        phoneNumbers[0] = firstNumberPhoneCode;
                    }
                    cleanPhoneNumber.append(phoneNumbers[i]);
                    count++;
                }
            }
        }
        cleanPhoneNumber.insert(2, "(");
        cleanPhoneNumber.insert(6, ")");
        cleanPhoneNumber.insert(10, "-");
        System.out.println(cleanPhoneNumber);
        if (count != numberPhoneLength) {
            throw new RuntimeException("Wrong phone number");
        }
        return String.valueOf(cleanPhoneNumber);
    }

    //второй вариант решения c регулярным выражением.
    public static String format(String phone) {
        String numbers = phone.replaceAll("[^\\d]", "");
        int len = numbers.length();
        if (len < 10 || len > 11) {
            throw new RuntimeException("Wrong phone number");
        }
        return "+" + (numbers.charAt(0) == '8' ? "7" : numbers.substring(0, 1))
                + "(" + numbers.substring(1, 4) + ")"
                + numbers.substring(4, 7) + "-" + numbers.substring(7);
    }

    public static void main(String[] args) {
        PhoneNumber one = new PhoneNumber();
        one.format("8u f(333) 788 - 28 - i23");
        System.out.println(one.format("8u f(333 788 - 28 - i23"));
    }
}
