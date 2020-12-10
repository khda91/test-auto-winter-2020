package ru.levelup.qa.at.selenium.step.design.pattern.steps;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ActionStep extends BaseStepClass {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public void openYandexMarketMainPage() {
        yandexMarketIndexPage.open();
    }

    public void openCategoryWithSubCategory(String category, String subCategory) {
        yandexMarketIndexPage.selectCategory(category);
        yandexMarketCategoryPage.selectCatalogItemPage(subCategory);
    }

    public List<String> addProductsToCompare(int... productIndex) {
        List<String> addedItems = new ArrayList<>();
        for (int index : productIndex) {
            addedItems.add(yandexMarketCatalogItemPage.addProductToCompare(index));
        }
        return addedItems;
    }

    public void clickToCompareButton() {
        yandexMarketCatalogItemPage.clickCompareButton();
    }
}
