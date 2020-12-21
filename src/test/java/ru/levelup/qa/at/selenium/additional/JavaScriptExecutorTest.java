package ru.levelup.qa.at.selenium.additional;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.utils.Sleep;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertTrue;

public class JavaScriptExecutorTest extends AbstractSeleniumBaseTest {

    @Test
    public void testJsExecutor() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://users.bugred.ru/");

        wait.until(elementToBeClickable(xpath("//a/span[text()='Войти']"))).click();

        wait.until(visibilityOfElementLocated(name("login"))).sendKeys("khda91@gmail.com");
        wait.until(visibilityOfElementLocated(name("password"))).sendKeys("1234");
        wait.until(elementToBeClickable(cssSelector("[value='Авторизоваться']"))).click();

        WebElement userDropdown = wait.until(visibilityOfElementLocated(className("dropdown-toggle")));

        assertTrue(userDropdown.isDisplayed());

        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("arguments[0].click();", userDropdown);

        Sleep.sleep(3000);
        wait.until(elementToBeClickable(linkText("Выход"))).click();

        assertTrue(wait.until(invisibilityOfElementLocated(className("dropdown-toggle"))));
        Sleep.sleep(3000);
    }
}
