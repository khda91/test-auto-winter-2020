package ru.levelup.qa.at.selenium.additional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.utils.Sleep;

import static org.testng.Assert.assertTrue;

public class SeleniumActionBuilderTest extends AbstractSeleniumBaseTest {

    @Test
    public void testActionBuilder() {
        driver.get("https://market.yandex.ru");

        WebElement catalogButton = driver.findElement(By.className("_2EPSjI-GdM"));
        catalogButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement catalogLayout = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tid='99f7866a db43cb6']")));

        assertTrue(catalogLayout.isDisplayed());

        WebElement товары_для_дома = wait
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(catalogLayout,
                        By.xpath(".//a[./span[text()='Товары для дома']]")));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(товары_для_дома)
                .perform();

//        catalogLayout.findElement(By.xpath(".//*[@class='_241BO-CL8_' and text()='Товары для дома']"));
        WebElement sectionTitle = wait
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(catalogLayout,
                        By.xpath(".//a[text()='Товары для дома']")));

        Keys ctrlCmd = System.getProperty("os.name").contains("Mac") ? Keys.COMMAND : Keys.LEFT_CONTROL;

        actions
                .keyDown(ctrlCmd)
                .click(driver.findElement(By.linkText("Новогодние товары")))
                .keyUp(ctrlCmd)
                .perform();

        Sleep.sleep(3000);
    }
}
