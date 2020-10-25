package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;

public class BigAlgebra {
    private static final int TWO = 2;
    BigDecimal fastPow(BigDecimal num, int pow) {
        String temp = Integer.toBinaryString(pow);
        int result = Integer.parseInt(temp);
        System.out.println(result);//test
        BigDecimal res = new BigDecimal(1);
        for (int i = temp.length() - 1; i >= 0; i--) {
            int low = (result >> i) & 1;
            System.out.println(low);//test
            res = res.multiply((num.pow(low).pow(TWO)));
            if (i == 0) {
                res = (res.pow(TWO)).multiply(num);
            }
        }
        return new BigDecimal(String.valueOf(res));
    }

    public static void main(String[] args) {
        BigAlgebra one = new BigAlgebra();
        System.out.println(one.fastPow(new BigDecimal(21), 13));

    }
}
