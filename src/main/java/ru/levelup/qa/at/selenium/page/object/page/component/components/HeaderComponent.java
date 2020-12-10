package ru.levelup.qa.at.selenium.page.object.page.component.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderComponent extends AbstractComponent {

    @FindBy(css = "[data-zone-name='category-link'] span")
    private List<WebElement> categoryItems;

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
}
