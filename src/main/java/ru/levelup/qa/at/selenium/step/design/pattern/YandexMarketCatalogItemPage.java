package ru.levelup.qa.at.selenium.step.design.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.qa.at.selenium.step.design.pattern.components.ProductCardComponent;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class YandexMarketCatalogItemPage extends AbstractBasePage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> products;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketCatalogItemPage(WebDriver driver) {
        super(driver);
    }

    public String addProductToCompare(int index) {
        return addProductToCompare(new ProductCardComponent(driver, products.get(index - 1)));
    }

    public void clickCompareButton() {
        wait.until(elementToBeClickable(compareButton)).click();
    }

    private String addProductToCompare(ProductCardComponent productCard) {
        productCard.clickToAddToCompareButton();
        return productCard.getProductName();
    }

}
