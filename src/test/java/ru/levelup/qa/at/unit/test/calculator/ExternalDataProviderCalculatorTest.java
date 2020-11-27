package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExternalDataProviderCalculatorTest extends AbstractBaseTest {

    @Test(dataProvider = "dataSetMultiply", dataProviderClass = CalculatorDataProviders.class)
    public void multiplyTest(double a, double b, double expected) {
        double multiply = calculator.multiply(a, b);
        assertEquals(multiply, expected);
    }

    @Test(dataProvider = "Data Set for Sum method", dataProviderClass = CalculatorDataProviders.class)
    public void sumTest(double a, double b, double expected) {
        double sum = calculator.sum(a, b);
        assertEquals(sum, expected);
    }

}
