package ru.levelup.qa.at.selenium.page.object.factory;

import org.openqa.selenium.WebDriver;

public class YandexMarketIndexPage extends AbstractBasePage {

    public YandexMarketIndexPage(WebDriver driver) {
        super(driver);
    }

    public YandexMarketIndexPage open() {
        open("");
        return this;
    }

}
