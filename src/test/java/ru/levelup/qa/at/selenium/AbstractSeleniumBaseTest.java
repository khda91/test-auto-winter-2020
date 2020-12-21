package ru.levelup.qa.at.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.qa.at.design.patterns.factory.WebDriverSingleton;
import ru.levelup.qa.at.selenium.allure.utils.AllurePropertiesGenerator;

public abstract class AbstractSeleniumBaseTest {

//    protected static WebDriver driver;
    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("browser.name", "chrome");
        AllurePropertiesGenerator.createAllureProperties();
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.getWebDriver();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

//    public static WebDriver getDriver() {
//        return driver;
//    }
}
