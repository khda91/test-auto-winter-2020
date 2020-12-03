package ru.levelup.qa.at.selenium.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SeleniumWaitsImplicitVsExplicitWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void testSeleniumImplicitExplicitPositiveTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb6']")));

        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumImplicitExplicitTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb6']")));
        assertTrue(catalogLayout.isDisplayed());

        catalogButton.click();
        Boolean catalogLayoutVisibility = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb6']")));
        assertTrue(catalogLayoutVisibility);
    }

    @Test
    public void testSeleniumImplicitExplicitNegativeTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb62121']")));
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumImplicitExplicitWithTimingNegativeTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        long start = System.currentTimeMillis();
        try {
            WebElement catalogLayout = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb62121']")));
            assertTrue(catalogLayout.isDisplayed());
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Timing: %s", (end - start)));
        }
    }

    @Test
    public void testSeleniumImplicitExplicitTogetherNegativeTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        long start = System.currentTimeMillis();
        try {
            WebElement catalogLayout = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb62121']")));
            assertTrue(catalogLayout.isDisplayed());
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Timing: %s", (end - start)));
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
