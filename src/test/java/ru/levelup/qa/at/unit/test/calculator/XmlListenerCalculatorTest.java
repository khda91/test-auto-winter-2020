package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.testng.Assert.assertEquals;

@Listeners({SimpleListener.class})
public class XmlListenerCalculatorTest extends AbstractBaseTest {

    @DataProvider
    public Object[][] dataSetMultiply() {
        return new Object[][]{
                {2.0, 2.0, 4.0},
                {-0.3, -.7, 0.21},
                {6, 15, 90},
                {70, 2.0, 140.0},
                {10, 10, 100},
        };
    }

    @Test(testName = "Multiply Test", dataProvider = "dataSetMultiply")
    public void multiplyTest(double a, double b, double expected) {
        double multiply = calculator.multiply(a, b);
        assertEquals(multiply, expected);
    }

    @DataProvider(name = "Data Set for Sum method")
    public Iterator<Object[]> dataSetSum() {
        return Arrays.asList(new Object[]{2.0, 2.0, 4.0},
                new Object[]{-0.3, -.7, -1.0},
                new Object[]{6D, 15D, 21D},
                new Object[]{70D, 2.0, 72.0},
                new Object[]{10D, 10D, 20D})
                .iterator();
    }

    @Test(dataProvider = "Data Set for Sum method")
    public void sumTest(double a, double b, double expected) {
        double sum = calculator.sum(a, b);
        assertEquals(sum, expected);
    }

    @DataProvider
    public Iterator<Object[]> dataSetSumString() {
        return Arrays.asList(new Object[]{"a", "2.0", "4.0"},
                new Object[]{"2.0", "2.0", "4.0"})
                .iterator();
    }

    @Test(dataProvider = "dataSetSumString")
    public void sumStringTest(double a, double b, double expected) {
        double sum = calculator.sum(a, b);
        assertEquals(sum, expected);
    }
}
