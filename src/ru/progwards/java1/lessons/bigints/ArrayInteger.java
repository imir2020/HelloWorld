package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
//Везде, где можно, применять BigInteger  и BigDecimal, а также отдельные экспериментальные классы и/или массивы

public class ArrayInteger {
    private byte[] digits;

    public ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        String str = value.toString();
        int res = str.length();
        //digits = new Byte[res];
        for (int i = 0; i < res; i++) {
            if (!value.equals(BigInteger.ZERO)) {
                digits[i] = value.mod(BigInteger.TEN).byteValueExact();
            }
            value = value.divide(BigInteger.TEN);
        }
        //Реверс массива
//        for (int i = 0; i < res / 2; i++) {
//            byte temp = digits[i];
//            digits[i] = digits[res - 1 - i];
//            digits[res - 1 - i] = temp;
//        }
    }

    BigInteger toInt() {
        String string;
        String result = "";
        for (int i = 0; i < digits.length; i++) {
            string = String.valueOf(digits[i]);
            result = result + string;
        }
        return new BigInteger(result);
    }

    boolean add(ArrayInteger num) {
        boolean responce = true;
        final int BASE = 10;
        int row = Math.max(num.digits.length, this.digits.length);
        byte[] temp = new byte[row];
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = (byte) (((num.digits.length <= i) ? 0 : num.digits[i]) + ((this.digits.length <= i) ? 0 : this.digits[i]));
            System.out.print(temp[i] + " r ");

        }
        for (int i = 0; i < row; i++) {
            if (temp[i] > (BASE - 1) && (i + 1) < temp.length) {
                temp[i] = (byte) (temp[i] - BASE);
                temp[i + 1] = (byte) (temp[i + 1] + 1);
            } else if (temp[i] > (BASE - 1) && (i + 1) >= temp.length) {
                for (int j = 0; j < row; j++) {
                    temp[j] = 0;
                }
                responce = false;

                //Дополнительная проверка, вмещается ли получившееся число в массив экземпляра, у которого вызвали метод.
            } else if (temp[i] <= BASE - 1 && this.digits.length < temp.length) {
                for (int j = 0; j < row; j++) {
                    temp[j] = 0;
                }
                responce = false;
            }
        }
////Реверс массива
//        for (int i = 0; i < temp.length / 2; i++) {
//            byte t = digits[i];
//            digits[i] = digits[temp.length - i];
//            digits[temp.length - 1 - i] = t;
//        }
//        for (Byte f: temp) {
//            System.out.print(f + " tr ");
//        }
        return responce;
    }


    public static void main(String[] args) {
        ArrayInteger one = new ArrayInteger(8);
        ArrayInteger two = new ArrayInteger(6);
        one.fromInt(new BigInteger("11084459"));
        two.fromInt(new BigInteger("118971"));
        one.toInt();
        System.out.println(one.toInt());
        //one.add(two);
        System.out.println(one.add(two));
        System.out.println(one.toInt());
    }
}
