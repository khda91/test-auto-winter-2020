package ru.levelup.qa.at.unit.test.calculator;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Iterator;

public class CalculatorDataProviders {

    @DataProvider
    public Object[][] dataSetMultiply() {
        return new Object[][] {
                {2.0, 2.0, 4.0},
                {-0.3, -.7, 0.21},
                {6, 15, 90},
                {70, 2.0, 140.0},
                {10, 10, 100},
        };
    }

    @DataProvider(name = "Data Set for Sum method")
    public Iterator<Object[]> dataSetSum() {
        return Arrays.asList(new Object[] {2.0, 2.0, 4.0},
                new Object[] {-0.3, -.7, -1.0},
                new Object[] {6D, 15D, 21D},
                new Object[] {70D, 2.0, 72.0},
                new Object[] {10D, 10D, 20D})
                .iterator();
    }
}
