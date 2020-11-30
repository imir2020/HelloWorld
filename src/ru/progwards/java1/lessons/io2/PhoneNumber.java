package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    //первый вариант решения.
    private static final String[] matrix = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final int numberPhoneLength = 11;

    private final static String numberPhoneCode = "+7";
    private final static String errorFirstNumber = "8";

    /*
    Это первая версия этого решения, вторая версия, - с регулярными выражениями, будет намного более
    компактной.
     */
    public static String format(String phone) {
        String[] phoneNumbers = new String[phone.length()];
        StringBuilder cleanPhoneNumber = new StringBuilder();
        int count = 0;

        /*
        В цикле проверить наличие в первой цифре  цифры 8, и если она есть, заменить её на +7.
         */
        for (int i = 0; i < phone.length(); i++) {
            phoneNumbers[i] = String.valueOf(phone.charAt(i));
            for (int j = 0; j < matrix.length; j++) {
                if (phoneNumbers[i].equals(matrix[j])) {
                    if (phoneNumbers[0].equals(errorFirstNumber)) {
                        phoneNumbers[0] = numberPhoneCode;
                    }
                    cleanPhoneNumber.append(phoneNumbers[i]);
                    count++;
                }
            }
            System.out.println(cleanPhoneNumber + "  " + count);//test
        }
        if (phone.length() != numberPhoneLength) {
            throw new RuntimeException("Wrong phone number");
        }
 /*
       В предыдущем цикле, получилось получить номер телефона.
       Теперь его нужно привести к формату, указанному в задании. То есть,
       нужно в цикле, перед и после, определенного количества цифр - трёх цифр, поставить
       скобки, а перед последними четырьмя, поставить тире.

         */
        return null;
    }

    public static void main(String[] args) {
        PhoneNumber one = new PhoneNumber();
        one.format("8 (333) 788 - 28 - 23");
    }
}
