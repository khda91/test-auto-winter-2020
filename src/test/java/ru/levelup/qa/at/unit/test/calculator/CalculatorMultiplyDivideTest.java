package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyDivideTest extends AbstractBaseTest {

    @Test
    public void testMultiply() {
        System.out.println("testMultiply method");
        double actual = calculator.multiply(4, 4);
        assertEquals(actual, 16);
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide method");
        double actual = calculator.divide(4, 4);
        assertEquals(actual, 1);
    }

    @Test
    public void testDivideNegative() {
        System.out.println("testDivideNegative method");
        double actual = calculator.divide(4, 0);
        assertEquals(actual, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testDivideNegative1() {
        System.out.println("testDivideNegative1 method");
        String actual = String.valueOf(calculator.divide(4, 0));
        assertEquals(actual, "Infinity");
    }

}
