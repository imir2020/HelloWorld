package ru.progwards.java1.lessons.bigints;


import java.math.BigDecimal;
import java.math.BigInteger;

//Везде, где можно, применять BigInteger  и BigDecimal, а также отдельные экспериментальные классы и/или массивы
//Перестать втискивать код в некие рамки дозволенного. Решать программы любыми доступными способами и методами.
public class BigAlgebra {

    static BigDecimal fastPow(BigDecimal num, int pow) {
        //заменить всё на BigDecimal
        String temp = Integer.toBinaryString(pow);
        int result = Integer.parseInt(temp);
        int low;
        BigDecimal res = BigDecimal.ONE;
        for (int i = temp.length() - 1; i >= 0; i--) {
            low = (result >> i) & 1;
            if (i != 0) {
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

    public static void main(String[] args) {
        BigAlgebra one = new BigAlgebra();
        System.out.println(one.fastPow(new BigDecimal(2), 100000));
        System.out.println(one.fibonacci(59));

    }
}
