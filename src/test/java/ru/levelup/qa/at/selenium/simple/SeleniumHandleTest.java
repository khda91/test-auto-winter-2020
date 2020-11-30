package ru.levelup.qa.at.selenium.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Sleep;

import java.util.ArrayList;
import java.util.List;

public class SeleniumHandleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void testSeleniumOneHandle() {
        Sleep.sleep(3000);

        System.out.println("Current window handle " + driver.getWindowHandle());
        System.out.println("All window handles " + driver.getWindowHandles());
    }

    @Test
    public void testSeleniumTwoHandles() {
        Sleep.sleep(3000);

        Keys ctrlCmd = System.getProperty("os.name").contains("Mac") ? Keys.COMMAND : Keys.LEFT_CONTROL;

        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Электроника']")));

        new Actions(driver)
                .keyDown(ctrlCmd)
                .click(element)
                .keyUp(ctrlCmd)
                .perform();

        Sleep.sleep(3000);

        System.out.println("Current window handle " + driver.getWindowHandle());
        System.out.println("All window handles " + driver.getWindowHandles());
    }

    @Test
    public void testSeleniumSwitchTwoHandles() {
        Sleep.sleep(3000);

        Keys ctrlCmd = System.getProperty("os.name").contains("Mac") ? Keys.COMMAND : Keys.LEFT_CONTROL;

        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Электроника']")));

        new Actions(driver)
                .keyDown(ctrlCmd)
                .click(element)
                .keyUp(ctrlCmd)
                .perform();

        Sleep.sleep(3000);

        System.out.println("Current window handle " + driver.getWindowHandle());
        System.out.println("All window handles " + driver.getWindowHandles());

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        int i = 1;
        do {
            driver.switchTo().window(handles.get(i));
            i++;
        } while (!driver.getTitle().contains("Электроника") || handles.size() != i);
        Sleep.sleep(3000);
        driver.close();
        Sleep.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
