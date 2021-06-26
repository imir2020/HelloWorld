package ru.progwards.java2.lessons.tests.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import static org.junit.Assert.assertEquals;

public class SimpleCalculatorExceptionTest {
    static SimpleCalculator one;

    @BeforeClass
    public static void init() {
        one = new SimpleCalculator();
    }

    @Test(expected = ArithmeticException.class)
    public void sumException() {
        assertEquals(Integer.MAX_VALUE + 1, one.sum(Integer.MAX_VALUE, 1));
    }

    @Test(expected = ArithmeticException.class)
    public void diffException() {
        assertEquals(Integer.MAX_VALUE + 1, one.diff(Integer.MAX_VALUE, -1));
        assertEquals(Integer.MIN_VALUE - 1, one.diff(Integer.MIN_VALUE, -1));
    }

    /*В данном методе выход за пределы диапазона возможен
     для любых двух правильно подобранных значений всего этого же диапазона.
     То есть  весь диапазон может быть "исключением".
    */
    @Test(expected = ArithmeticException.class)
    public void multException() {
        assertEquals(Integer.MAX_VALUE * Integer.MIN_VALUE, one.mult(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE * Integer.MIN_VALUE, one.mult(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test(expected = ArithmeticException.class)
    public void divException() {
        assertEquals(0, one.div(1, 0));
        assertEquals(0, one.div(0, 0));
    }

    @AfterClass
    public static void collapse() {
        one = null;
    }
}
