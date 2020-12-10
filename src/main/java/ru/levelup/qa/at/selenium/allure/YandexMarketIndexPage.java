package ru.levelup.qa.at.selenium.allure;

import org.openqa.selenium.WebDriver;

public class YandexMarketIndexPage extends AbstractBasePage {

    public YandexMarketIndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

}
