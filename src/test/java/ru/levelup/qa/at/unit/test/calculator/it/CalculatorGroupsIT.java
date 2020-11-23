package ru.levelup.qa.at.unit.test.calculator.it;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.unit.test.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalculatorGroupsIT {

    Calculator calculator;

    @BeforeGroups(groups = {"simpleOperations"})
    public void beforeGroup() {
        System.out.println("before group method");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up method");
        calculator = new Calculator();
    }

    @Test(groups = {"simpleOperations"})
    public void testSum() {
        System.out.println("testSum method");
        double actual = calculator.sum(4, 4);
        assertEquals(actual, 8);
    }

    @Test(groups = {"simpleOperations"})
    public void testMultiply() {
        System.out.println("testMultiply method");
        double actual = calculator.multiply(4, 4);
        assertEquals(actual, 16);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down method");
        calculator = null;
    }

}
