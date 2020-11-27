package ru.levelup.qa.at.unit.test.calculator.it;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.levelup.qa.at.unit.test.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalculatorSimple02IT {

    Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("CalculatorSimple02IT before Class method");
    }

    @Before
    public void setUp() {
        System.out.println("set up method");
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        System.out.println("testSum method");
        double actual = calculator.sum(4, 4);
        assertEquals(actual, 8);
    }

    @Test
    public void testMultiply() {
        System.out.println("testMultiply method");
        double actual = calculator.multiply(4, 4);
        assertEquals(actual, 16);
    }

    @After
    public void tearDown() {
        System.out.println("tear down method");
        calculator = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after Class method");
    }
}
