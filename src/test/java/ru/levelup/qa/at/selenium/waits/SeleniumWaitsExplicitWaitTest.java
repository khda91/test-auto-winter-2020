package ru.levelup.qa.at.selenium.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SeleniumWaitsExplicitWaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void testSeleniumExplicitPositiveTest() {
        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb6']")));

        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumExplicitWebDriverWaitNegativeTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        WebElement catalogButton = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("_2EPSjI-GdM1231")));
        catalogButton.click();

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumExplicitWebDriverWaitWithPoolingIntervalNegativeTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5, 2000);
        WebElement catalogButton = webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("_2EPSjI-GdM1231")));
        catalogButton.click();

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumExplicitFluentNegativeTest() {
        FluentWait<WebDriver> fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5, 900))
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Unable find element")
                .ignoring(NoSuchElementException.class);
        WebElement catalogButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_2EPSjI-GdM1231")));
        catalogButton.click();

        WebElement catalogLayout = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumExplicitCustomPositiveTest() {
        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {
                        WebElement element = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb6']"));
                        return element.isDisplayed() ? element : null;
                    }
                });

        assertTrue(catalogLayout.isDisplayed());
    }

    @Test
    public void testSeleniumExplicitCustomNegativeTest() {
        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebElement catalogLayout = new WebDriverWait(driver, 5)
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {
                        WebElement element = driver.findElement(By.cssSelector("[data-tid='99f7866a db43cb61231']"));
                        return element.isDisplayed() ? element : null;
                    }
                });

        assertTrue(catalogLayout.isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
