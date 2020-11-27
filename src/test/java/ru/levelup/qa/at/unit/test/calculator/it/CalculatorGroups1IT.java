package ru.levelup.qa.at.unit.test.calculator.it;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelup.qa.at.unit.test.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalculatorGroups1IT {

    Calculator calculator;

    @Before
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up method");
        calculator = new Calculator();
    }

    @Test
    public void testCos() {
        System.out.println("testCos method");
        double actual = calculator.cos(4);
        assertEquals(actual, Math.cos(4));
    }

    @Test
    public void testCosNeg() {
        System.out.println("testCos method");
        double actual = calculator.cos(4);
        assertEquals(actual, Math.cos(4));
    }

    @After
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down method");
        calculator = null;
    }


}
