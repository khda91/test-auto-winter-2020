package ru.levelup.qa.at.selenium.page.object.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractBasePage {

//    private static final String BASE_URL = "https://market.yandex.ru/";
    private static final String BASE_URL;

    static {
        Properties properties = new Properties();
        try {
            properties.load(AbstractBasePage.class.getClassLoader().getResourceAsStream("selenium/pageobject.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE_URL = properties.getProperty("base.url");
    }

    protected WebDriver driver;

    protected WebDriverWait wait;

    @FindBy(css = "[data-zone-name='category-link'] span")
    private List<WebElement> categoryItems;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }

    public YandexMarketCategoryPage selectCategory(String categoryName) {
        WebElement webElement = categoryItems
                .stream()
                .filter(item -> item.getText().equalsIgnoreCase(categoryName))
                .findFirst()
                .get();
        click(webElement);
        return new YandexMarketCategoryPage(driver);
    }

    protected void click(WebElement element) {
        long start = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Execution time;Click;%s;%.3f", element,((double)(end - start) / 1000)));
        }
    }

}
