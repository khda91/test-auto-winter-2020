package ru.levelup.qa.at.selenium.allure.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HeaderComponent extends AbstractComponent {

    @FindBy(css = "[data-zone-name='category-link'] span")
    private List<WebElement> categoryItems;

    @FindBy(id = "pokupki")
    private WebElement searchArea;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String categoryName) {
        categoryItems
                .stream()
                .filter(item -> item.getText().equalsIgnoreCase(categoryName))
                .findFirst()
                .get()
                .click();
    }

    public void selectSearchArea(String value) {
        Select select = new Select(searchArea);
        select.selectByVisibleText(value);
    }
}
