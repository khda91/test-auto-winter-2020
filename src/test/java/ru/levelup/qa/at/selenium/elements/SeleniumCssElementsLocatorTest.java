package ru.levelup.qa.at.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.utils.Sleep;

import java.util.List;

public class SeleniumCssElementsLocatorTest extends AbstractSeleniumBaseTest {

    @Test
    public void testLocators() {
        driver.get("https://market.yandex.ru/");

        WebElement headerSearchInput = driver.findElement(By.cssSelector("#header-search"));
        headerSearchInput.sendKeys("Помогатор");
        Sleep.sleep(3000);

//        WebElement headerSearchButton = driver.findElement(By.cssSelector("[class='_1XiEJDPVpk']"));
        WebElement headerSearchButton = driver.findElement(By.cssSelector("._1XiEJDPVpk"));
        headerSearchButton.click();
        Sleep.sleep(1500);

        List<WebElement> articleElements = driver.findElements(By.cssSelector("article"));
        System.out.println("Amount of articles: " + articleElements.size());

        driver.findElement(By.cssSelector("div[data-zone-data='{\"id\":\"91542583\"}']")).click();
        Sleep.sleep(1500);

        driver.findElement(By.cssSelector("div[role='tablist'] div[data-zone-data='{\"id\":\"91542578\"}']")).click();
        Sleep.sleep(1500);
    }


}
