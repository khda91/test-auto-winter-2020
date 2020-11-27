package ru.levelup.qa.at.unit.test.calculator.it;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.levelup.qa.at.unit.test.calculator.Calculator;

public abstract class AbstractBaseIT {

    protected Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println(AbstractBaseIT.class.getName() + " before Class method");
    }

    @Before
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up method");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down method");
        calculator = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println(AbstractBaseIT.class.getName() + " after Class method");
    }

}
