package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumSubstractTest extends AbstractBaseTest {

    @Test
    public void testSum() {
        System.out.println("testSum method");
        double actual = calculator.sum(4, 4);
        assertEquals(actual, 8);
    }

    @Test
    public void testSubstract() {
        System.out.println("testSubstract method");
        double actual = calculator.substract(4, 4);
        assertEquals(actual, 0);
    }

}
