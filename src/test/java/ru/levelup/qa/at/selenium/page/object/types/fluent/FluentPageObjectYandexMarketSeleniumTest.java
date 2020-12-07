package ru.levelup.qa.at.selenium.page.object.types.fluent;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.selenium.page.object.factory.YandexMarketCatalogItemPage;
import ru.levelup.qa.at.selenium.page.object.factory.YandexMarketIndexPage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class FluentPageObjectYandexMarketSeleniumTest extends AbstractSeleniumBaseTest {

    @Test
    public void samplePageFactoryPageObjectTest() {
        YandexMarketCatalogItemPage yandexMarketCatalogItemPage =
                new YandexMarketIndexPage(driver)
                        .open()                                                     // 1. Открыть Яндекс маркет
                        .selectCategory("Компьютеры")                  // 2. Выбрать категорию "Компьютеры"
                        .selectCatalogItemPage("Ноутбуки");             // 3. Выбрать подкатегорию "Ноутбуки"

        List<String> selectedProductNames = new ArrayList<>();
        // 4. Добавить первый товар к сравнению
        String firstProduct = yandexMarketCatalogItemPage.addProductToCompare(1);
        selectedProductNames.add(firstProduct);

        // 5. добавить второй товар к сравнению
        String secondProduct = yandexMarketCatalogItemPage.addProductToCompare(2);
        selectedProductNames.add(secondProduct);

        List<String> comparedProductNames = yandexMarketCatalogItemPage
                .clickCompareButton()                    // 6. Нажать на кнопку сравнить товары
                .getProductNames();//7. Проверить, что выбранные товары были добавлены к сравнению

        assertThat(comparedProductNames,
                containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
