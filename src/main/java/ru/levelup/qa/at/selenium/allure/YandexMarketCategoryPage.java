package ru.levelup.qa.at.selenium.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;

public class YandexMarketCategoryPage extends AbstractBasePage {

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие подкатегории '{subCategory}'")
    public void selectCatalogItemPage(String subCategory) {
        wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText(subCategory)))
                .click();
        Allure.getLifecycle().addAttachment(subCategory + "_url", "plain/text", "txt",
                driver.getCurrentUrl().getBytes());
        Allure.addAttachment(subCategory + "_pageSource", "text/html", driver.getPageSource(), "html");
    }
}
