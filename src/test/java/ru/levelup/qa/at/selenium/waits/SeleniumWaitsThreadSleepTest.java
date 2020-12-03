package ru.levelup.qa.at.selenium.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SeleniumWaitsThreadSleepTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void testSeleniumThreadSleepTest() throws InterruptedException {
        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        Thread.sleep(5500);

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
