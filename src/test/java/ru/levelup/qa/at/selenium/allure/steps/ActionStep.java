package ru.levelup.qa.at.selenium.allure.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ActionStep extends BaseStepClass {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие главной странице Яндекс Маркета")
    public void openYandexMarketMainPage() {
        yandexMarketIndexPage.open();
    }

    @Step("Открытие категории '{category}' и подкатегории '{1}'")
    public void openCategoryWithSubCategory(String category, String subCategory) {
        yandexMarketIndexPage.selectCategory(category);
        yandexMarketCategoryPage.selectCatalogItemPage(subCategory);
    }

    public List<String> addProductsToCompare(int... productIndex) {
        Allure.step("Добавляем " + productIndex.length + " продукта к сравнению");
        List<String> addedItems = new ArrayList<>();
        for (int index : productIndex) {
            addedItems.add(yandexMarketCatalogItemPage.addProductToCompare(index));
        }
        return addedItems;
    }

    @Step("Нажать на кнопку 'Сравнить'")
    public void clickToCompareButton() {
        yandexMarketCatalogItemPage.clickCompareButton();
    }
}
