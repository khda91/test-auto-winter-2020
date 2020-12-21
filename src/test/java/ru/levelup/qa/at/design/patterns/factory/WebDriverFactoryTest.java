package ru.levelup.qa.at.design.patterns.factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Sleep;

public class WebDriverFactoryTest {

    private WebDriver driver;

    @Test
    public void testName() {
        driver = WebDriverFactory.createWebDriver("firefox");
        driver.get("https://ya.ru");

        Sleep.sleep(3000);
    }

    @Test
    public void testName1() {
        driver = WebDriverFactory.createWebDriver("edge");
        driver.get("https://ya.ru");

        Sleep.sleep(3000);
    }

    @Test
    public void testName2() {
        driver = WebDriverFactory.createWebDriver("opera");
        driver.get("https://ya.ru");

        Sleep.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
