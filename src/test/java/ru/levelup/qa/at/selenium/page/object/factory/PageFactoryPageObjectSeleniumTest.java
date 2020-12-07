package ru.levelup.qa.at.selenium.page.object.factory;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class PageFactoryPageObjectSeleniumTest extends AbstractSeleniumBaseTest {

    YandexMarketIndexPage yandexMarketIndexPage;
    YandexMarketCategoryPage yandexMarketCategoryPage;
    YandexMarketCatalogItemPage yandexMarketCatalogItemPage;
    YandexMarketCompareProductPage yandexMarketCompareProductPage;

    @Test
    public void samplePageFactoryPageObjectTest() {
        yandexMarketIndexPage = new YandexMarketIndexPage(driver);

        // 1. Открыть Яндекс маркет
        yandexMarketIndexPage = yandexMarketIndexPage.open();

        // 2. Выбрать категорию "Компьютеры"
        yandexMarketCategoryPage = yandexMarketIndexPage.selectCategory("Компьютеры");

        // 3. Выбрать подкатегорию "Ноутбуки"
        yandexMarketCatalogItemPage = yandexMarketCategoryPage.selectCatalogItemPage("Ноутбуки");

        List<String> selectedProductNames = new ArrayList<>();
        // 4. Добавить первый товар к сравнению
        String firstProduct = yandexMarketCatalogItemPage.addProductToCompare(1);
        selectedProductNames.add(firstProduct);

        // 5. добавить второй товар к сравнению
        String secondProduct = yandexMarketCatalogItemPage.addProductToCompare(2);
        selectedProductNames.add(secondProduct);

        // 6. Нажать на кнопку сравнить товары
        yandexMarketCompareProductPage = yandexMarketCatalogItemPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        List<String>comparedProductNames = yandexMarketCompareProductPage.getProductNames();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
