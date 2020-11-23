package ru.levelup.qa.at.unit.test.calculator.it;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.test.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalculatorSimpleIT {

    Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("before Class method");
    }

    @BeforeMethod
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

    @AfterMethod
    public void tearDown() {
        System.out.println("tear down method");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after Class method");
    }
}
