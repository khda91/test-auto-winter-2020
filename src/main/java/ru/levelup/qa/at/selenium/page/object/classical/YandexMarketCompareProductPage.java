package ru.levelup.qa.at.selenium.page.object.classical;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;

public class YandexMarketCompareProductPage {

    private WebDriver driver;

    public YandexMarketCompareProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductNames() {
        List<WebElement> comparedProducts = new WebDriverWait(driver, 10)
                .until(numberOfElementsToBeMoreThan(
                        cssSelector("[data-tid='412661c'] a.cia-cs"), 1));
        return  comparedProducts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
