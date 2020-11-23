package ru.levelup.qa.at.unit.test.calculator.it;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelup.qa.at.unit.test.calculator.Calculator;

public abstract class AbstractBaseIT {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before Suite method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before Test method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " before Class method");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up method");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down method");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " after Class method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after Test method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after Suite method");
    }

}
