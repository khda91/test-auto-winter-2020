package ru.levelup.qa.at.selenium.step.design.pattern.steps;

import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class AssertionStep extends BaseStepClass {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    public void assertThatAddedProductsShouldBeDisplayedOnTheComparePage(List<String> expectedSelectedProducts) {
        List<String> actualSelectedProducts = yandexMarketCompareProductPage.getProductNames();
        assertThat(actualSelectedProducts, containsInAnyOrder(expectedSelectedProducts.toArray(new String[expectedSelectedProducts.size()])));
    }
}
