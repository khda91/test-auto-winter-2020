package ru.levelup.qa.at.selenium.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Sleep;

import static org.testng.Assert.assertEquals;

public class SimpleSeleniumTest {

    @Test
    public void simpleSeleniumTest() {
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader()
                .getResource("selenium/drivers/chrome/chromedriver").getPath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Sleep.sleep(3000);

        assertEquals(driver.getTitle(),
                "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");
        driver.close();
    }

    @Test
    public void simpleSeleniumTest1() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Sleep.sleep(3000);

        assertEquals(driver.getTitle(),
                "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");
        driver.close();
    }

    @Test
    public void simpleSeleniumTest2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Sleep.sleep(3000);

        assertEquals(driver.getTitle(),
                "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");
        driver.close();
    }

}
