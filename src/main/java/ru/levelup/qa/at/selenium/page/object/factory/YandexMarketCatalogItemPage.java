package ru.levelup.qa.at.selenium.page.object.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class YandexMarketCatalogItemPage extends AbstractBasePage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> products;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketCatalogItemPage(WebDriver driver) {
        super(driver);
    }

    public String addProductToCompare(int index) {
        return addProductToCompare(products, index - 1);
    }

    public YandexMarketCompareProductPage clickCompareButton() {
        wait.until(elementToBeClickable(compareButton)).click();
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
