package ru.progwards.java1.lessons.bigints;


        import java.math.BigDecimal;
        import java.math.BigInteger;

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {
        String temp = Integer.toBinaryString(pow);
        int result = Integer.parseInt(temp);
        int low;
        BigDecimal res = BigDecimal.ONE;
        for (int i = temp.length() - 1; i >= 0; i--) {
            low = (result >> i) & 1;
            if (i !=0) {
                res = res.multiply(num.pow(low));
                res = res.pow(2);
            }
            if (i == 0) {
                res = res.multiply(num.pow(low));
            }
        }
        return new BigDecimal(String.valueOf(res));
    }

    static BigInteger fibonacci(int n) {
        BigInteger sum = BigInteger.ONE;
        BigInteger previousNumber = BigInteger.ZERO;
        BigInteger nextNumber = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            sum = previousNumber.add(nextNumber);
            previousNumber = nextNumber;
            nextNumber = sum;
        }
        return new BigInteger(String.valueOf(sum));
    }
    //    Задача 1. Класс BigAlgebra:
//    Ошибка 1: non-static method fastPow(java.math.BigDecimal,int) cannot be referenced from a static context
//    Ошибка 2: non-static method fibonacci(int) cannot be referenced from a static context
    public static void main(String[] args) {
        BigAlgebra one = new BigAlgebra();
        System.out.println(one.fastPow(new BigDecimal(21), 13));
        System.out.println(one.fibonacci(59));

    }
}
