package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorGroups1Test {

    Calculator calculator;

    @BeforeGroups(groups = {"simpleOperations", "trig"})
    public void beforeGroup() {
        System.out.println("before group method");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up method");
        calculator = new Calculator();
    }

    @Test(groups = {"simpleOperations", "trig"})
    public void testCos() {
        System.out.println("testCos method");
        double actual = calculator.cos(4);
        assertEquals(actual, Math.cos(4));
    }

    @Test(groups = {"simpleOperations", "trig"})
    public void testCosNeg() {
        System.out.println("testCos method");
        double actual = calculator.cos(4);
        assertEquals(actual, Math.cos(4));
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down method");
        calculator = null;
    }


}
