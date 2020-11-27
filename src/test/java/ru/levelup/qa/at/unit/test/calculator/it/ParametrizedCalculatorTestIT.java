package ru.levelup.qa.at.unit.test.calculator.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedCalculatorTestIT extends AbstractBaseIT {

    @Parameters
    public static Collection<Object[]> dataSet() {
        return Arrays.asList(new Object[][]{
                {2.0, 2.0, 4.0},
                {40.4, 40.2, 80.6},
                {-.04, 9.94, 9.9}
        });
    }

    private double a;
    private double b;
    private double expected;

    public ParametrizedCalculatorTestIT(double a, double b, double expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Test
    public void sumParametrizedTest() {
        double sum = calculator.sum(a, b);
        assertEquals(expected, sum, 0.00001);
    }
}
