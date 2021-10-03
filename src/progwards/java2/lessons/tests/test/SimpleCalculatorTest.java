package ru.progwards.java2.lessons.tests.test;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(Enclosed.class)
public class SimpleCalculatorTest {

    @RunWith(Parameterized.class)
    public static class SumTest {
        SimpleCalculator one = new SimpleCalculator();
        public int val1;
        public int val2;
        public int expected;

        public SumTest(int val1, int val2, int expected) {
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Iterable<Object[]> dataTest1() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 2},
                    {2, 3, 5},
                    {5, 6, 11},
            });
        }

        @Test
        public void testOfOperation() {
            assertEquals(expected, one.sum(val1, val2));
        }
    }

    @RunWith(Parameterized.class)
    public static class DiffTest {
        SimpleCalculator one = new SimpleCalculator();
        public int val1;
        public int val2;
        public int expected;

        public DiffTest(int val1, int val2, int expected) {
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Iterable<Object[]> dataTest1() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 0},
                    {2, 3, -1},
                    {5, 6, -1},
            });
        }

        @Test
        public void testOfOperation() {
            assertEquals(expected, one.diff(val1, val2));
        }
    }

    @RunWith(Parameterized.class)
    public static class MultTest {
        SimpleCalculator one = new SimpleCalculator();
        public int val1;
        public int val2;
        public int expected;

        public MultTest(int val1, int val2, int expected) {
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Iterable<Object[]> dataTest1() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 1},
                    {2, 3, 6},
                    {5, 6, 30},
            });
        }

        @Test
        public void testOfOperation() {
            assertEquals(expected, one.mult(val1, val2));
        }
    }

    @RunWith(Parameterized.class)
    public static class DivTest {
        SimpleCalculator one = new SimpleCalculator();
        public int val1;
        public int val2;
        public int expected;

        public DivTest(int val1, int val2, int expected) {
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Iterable<Object[]> dataTest1() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 1},
                    {9, 3, 3},
                    {14, 7, 2},
            });
        }

        @Test
        public void testOfOperation() {
            assertEquals(expected, one.div(val1, val2));
        }
    }
}
