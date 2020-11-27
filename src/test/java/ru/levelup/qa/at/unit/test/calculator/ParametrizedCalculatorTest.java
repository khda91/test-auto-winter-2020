package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParametrizedCalculatorTest extends AbstractBaseTest {

    @Test
    @Parameters({"a", "b", "expected"})
    public void parametrizedSumTest(double a, double b, double expected) {
        double sum = calculator.sum(a, b);
        assertEquals(sum, expected);
    }

    @Test
    @Parameters({"a", "b", "expected"})
    public void parametrizedMultiplyTest(@Optional("3.0") double a, double b, double expected) {
        double multiply = calculator.multiply(a, b);
        assertEquals(multiply, expected);
    }
}
