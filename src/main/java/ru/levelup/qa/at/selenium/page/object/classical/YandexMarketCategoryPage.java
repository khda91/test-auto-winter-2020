package ru.levelup.qa.at.selenium.page.object.classical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketCategoryPage {

    private WebDriver driver;

    public YandexMarketCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public YandexMarketCatalogItemPage selectCatalogItemPage(String subCategory) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(By.linkText(subCategory)))
                .click();
        return new YandexMarketCatalogItemPage(driver);
    }
}
