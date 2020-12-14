package ru.levelup.qa.at.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelup.qa.at.selenium.allure.utils.AllurePropertiesGenerator;

public abstract class AbstractSeleniumBaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        AllurePropertiesGenerator.createAllureProperties();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
