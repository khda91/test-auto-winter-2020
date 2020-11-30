package ru.levelup.qa.at.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.utils.Sleep;

import java.util.List;

public class SeleniumDomElementsLocatorTest extends AbstractSeleniumBaseTest {

    @Test
    public void testLocators() {
        driver.get("https://market.yandex.ru/");

        WebElement headerSearchInput = driver.findElement(By.id("header-search"));
        headerSearchInput.sendKeys("Помогатор");
        Sleep.sleep(3000);

        WebElement headerSearchButton = driver.findElement(By.className("_1XiEJDPVpk"));
        headerSearchButton.click();
        Sleep.sleep(1500);

        List<WebElement> articleElements = driver.findElements(By.tagName("article"));
        System.out.println("Amount of articles: " + articleElements.size());

        driver.findElement(By.partialLinkText("Бытовая техника")).click();
        Sleep.sleep(1500);
    }


}
