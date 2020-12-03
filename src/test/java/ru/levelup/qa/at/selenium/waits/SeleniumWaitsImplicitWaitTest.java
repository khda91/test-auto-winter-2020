package ru.levelup.qa.at.selenium.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SeleniumWaitsImplicitWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5500, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(250, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);

        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void testSeleniumImplicitPositiveTest() {
        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumImplicitNegativeTest() {
        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM1231"));
        catalogButton.click();

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumImplicitNegativeWithTimingTest() {
        long startTime = System.currentTimeMillis();
        try {
            WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM1231"));
            catalogButton.click();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Time for element search: %s", (endTime - startTime)));
        }

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
