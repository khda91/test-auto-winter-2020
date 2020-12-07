package ru.levelup.qa.at.selenium.page.object.classical;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class YandexMarketCatalogItemPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public YandexMarketCatalogItemPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String addProductToCompare(int index) {
        List<WebElement> products = wait.until(numberOfElementsToBeMoreThan(cssSelector("[data-autotest-id='product-snippet']"), 3));
        return addProductToCompare(products, index - 1);
    }

    public YandexMarketCompareProductPage clickCompareButton() {
        wait.until(elementToBeClickable(xpath("//a/span[text()='Сравнить']"))).click();
        return new YandexMarketCompareProductPage(driver);
    }

    private String addProductToCompare(List<WebElement> products, int productNumber) {
        WebElement addToCompare = wait.until(presenceOfNestedElementLocatedBy(products.get(productNumber),
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
        return wait.until(visibilityOf(products.get(productNumber)
                .findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }

}
