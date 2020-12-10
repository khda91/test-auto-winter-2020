package ru.levelup.qa.at.selenium.step.design.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelup.qa.at.selenium.step.design.pattern.components.AbstractComponent;
import ru.levelup.qa.at.selenium.step.design.pattern.components.HeaderComponent;

public abstract class AbstractBasePage extends AbstractComponent {

    private static final String BASE_URL = "https://market.yandex.ru/";

    protected HeaderComponent header;

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }

    protected void click(WebElement element) {
        long start = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(String.format("Execution time;Click;%s;%.3f", element, ((double) (end - start) / 1000)));
        }
    }

    public void selectCategory(String categoryName) {
        header.selectCategory(categoryName);
    }

    public HeaderComponent header() {
        return this.header;
    }
}
