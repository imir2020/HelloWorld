package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;


public class ArrayInteger {
    private Byte[] digits;

    public ArrayInteger(int n) {
        digits = new Byte[n];
    }

    void fromInt(BigInteger value) {
        String str = value.toString();
        int res = str.length();
        digits = new Byte[res];
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

    //    boolean add(ArrayInteger num) {
//        boolean responce = true;
//        byte ten = 0;
//        int row = Math.max(num.digits.length, this.digits.length);
//        byte result;
//        byte[] temp = new byte[row];
//        for (int i = temp.length - 1; i >= 0; i--) {
//            if(num.digits.length <= i){
//                temp[i] = 0;
//            }
//
//            temp[i] = (byte) (((num.digits.length <= i) ? 0 : num.digits[i])
//                    + ((this.digits.length <= i) ? 0 : this.digits[i]) + ten);
//            if (temp[i] > 9) {
//                ten = (byte) (temp[i] > 9 ? 1 : 0);
//                temp[i] = 0;
//            }
//            System.out.print(temp[i] + " temp ");
//
//        }
//
//        return responce;
//
//    }
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
            } else if (temp[i] > (BASE - 1) && (i + 1) >= temp.length ) {
                for (int j = 0; j < row ; j++) {
                    temp[j] = 0;
                }
                responce = false;

                //Дополнительная проверка, вмещается ли получившееся число в массив экземпляра, у которого вызвали метод.
            } else if(temp[i] <= BASE - 1 &&this.digits.length <temp.length){
                for (int j = 0; j < row ; j++) {
                    temp[j] = 0;
                }
                responce = false;
            }
        }

        for (Byte f: temp) {
            System.out.print(f + " tr ");
        }
        return responce;
    }

//    boolean add(ArrayInteger num) {
//        boolean responce = true;
//        final int BASE = 10;
//        int count = Math.min(num.digits.length, this.digits.length);
//        for (int i = 0; i < count; i++) {
//            for (int j = 0; j < count; j++) {
//                this.digits[i] = (byte) (this.digits[i] + num.digits[j]);
//            }
//            System.out.println(this.digits[i]);
//        }
//        for (int i = 0; i < this.digits.length; i++) {
//            if (this.digits[i] > (BASE - 1) && (i + 1) < this.digits.length) {
//                this.digits[i] = (byte) (this.digits[i] - BASE);
//                this.digits[i + 1] = (byte) (this.digits[i + 1] + 1);
//            } else if (this.digits[i] > (BASE - 1) && (i + 1) >= this.digits.length) {
//                this.digits[i] = 0;
//             responce = false;
//            }
//            System.out.print(digits[i] + " try ");
//        }
//        return responce;
//    }

    public static void main(String[] args) {
        ArrayInteger one = new ArrayInteger(3);
        ArrayInteger two = new ArrayInteger(3);
        one.fromInt(new BigInteger("11"));
        two.fromInt(new BigInteger("86"));
        // one.toInt();
        //System.out.println(one.toInt());
        //one.add(two);
        System.out.println(one.add(two));
    }
}
