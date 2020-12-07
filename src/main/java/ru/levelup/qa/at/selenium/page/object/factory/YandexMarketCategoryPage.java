package ru.levelup.qa.at.selenium.page.object.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YandexMarketCategoryPage extends AbstractBasePage {

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketCatalogItemPage selectCatalogItemPage(String subCategory) {
        wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText(subCategory)))
                .click();
        return new YandexMarketCatalogItemPage(driver);
    }
}
