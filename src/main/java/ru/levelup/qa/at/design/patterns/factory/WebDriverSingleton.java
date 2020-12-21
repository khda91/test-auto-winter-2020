package ru.levelup.qa.at.design.patterns.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver(System.getProperty("browser.name"));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
