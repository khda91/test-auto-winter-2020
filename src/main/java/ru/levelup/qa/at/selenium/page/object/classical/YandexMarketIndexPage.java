package ru.levelup.qa.at.selenium.page.object.classical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketIndexPage {

    private static final String URL = "https://market.yandex.ru/";

    private WebDriver driver;

    public YandexMarketIndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public YandexMarketIndexPage open() {
        driver.navigate().to(URL);
        return this;
    }

    public YandexMarketCategoryPage selectCategory(String categoryName) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//span[contains(text(),'%s')]", categoryName))
                )).click();
        return new YandexMarketCategoryPage(driver);
    }

}
