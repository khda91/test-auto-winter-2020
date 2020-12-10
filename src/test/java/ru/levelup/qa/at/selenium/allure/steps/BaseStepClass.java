package ru.levelup.qa.at.selenium.allure.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.qa.at.selenium.allure.YandexMarketCatalogItemPage;
import ru.levelup.qa.at.selenium.allure.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.allure.YandexMarketCompareProductPage;
import ru.levelup.qa.at.selenium.allure.YandexMarketIndexPage;

public abstract class BaseStepClass {

    private WebDriver driver;

    YandexMarketIndexPage yandexMarketIndexPage;
    YandexMarketCategoryPage yandexMarketCategoryPage;
    YandexMarketCatalogItemPage yandexMarketCatalogItemPage;
    YandexMarketCompareProductPage yandexMarketCompareProductPage;

    public BaseStepClass(WebDriver driver) {
        this.driver = driver;
        yandexMarketIndexPage = new YandexMarketIndexPage(driver);
        yandexMarketCategoryPage = new YandexMarketCategoryPage(driver);
        yandexMarketCatalogItemPage = new YandexMarketCatalogItemPage(driver);
        yandexMarketCompareProductPage = new YandexMarketCompareProductPage(driver);
    }

}
