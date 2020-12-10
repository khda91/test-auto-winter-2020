package ru.levelup.qa.at.selenium.step.design.pattern.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.qa.at.selenium.step.design.pattern.YandexMarketCatalogItemPage;
import ru.levelup.qa.at.selenium.step.design.pattern.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.step.design.pattern.YandexMarketCompareProductPage;
import ru.levelup.qa.at.selenium.step.design.pattern.YandexMarketIndexPage;

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
