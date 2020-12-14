package ru.levelup.qa.at.selenium.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.selenium.allure.steps.ActionStep;
import ru.levelup.qa.at.selenium.allure.steps.AssertionStep;

import java.io.IOException;
import java.util.List;

@Epic("Сравнение товаров")
@Feature("Сравнение товаров 2")
public class AllureSelenium1Test extends AbstractSeleniumBaseTest {

    private ActionStep actionStep;
    private AssertionStep assertionStep;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @Story("Категория компьютеры")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "Проверка добавления к сравнению товаров из категории компьютеры")
    @Link("https://market.yandex.ru")
    @TmsLink("QAAT-21") @Issue("QAAT-19")
    public void computersTest() {
        // 1. Открыть Яндекс маркет
        actionStep.openYandexMarketMainPage();

        // 2. Выбрать категорию "Компьютеры"
        // 3. Выбрать подкатегорию "Ноутбуки"
        actionStep.openCategoryWithSubCategory("Компьютеры", "Ноутбуки");

        // 4. Добавить первый товар к сравнению
        // 5. добавить второй товар к сравнению
        List<String> selectedProductNames = actionStep.addProductsToCompare(1, 2);

        // 6. Нажать на кнопку сравнить товары
        actionStep.clickToCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        selectedProductNames.add("sdjfbsvjkbfdkjvf");
        assertionStep.assertThatAddedProductsShouldBeDisplayedOnTheComparePage(selectedProductNames);
    }

    @Story("Категория бытовая техника")
    @Description("Тест проверяющий возможность добавления к сравнению 3-х товаров из категории 'Электроника'")
    @Test(description = "Проверка добавления к сравнению товаров из категории бытовая техника")
    @Link(url = "https://market.yandex.ru", name = "Главная страница")
    @TmsLinks({@TmsLink("QAAT-23"), @TmsLink("QAAT-40")})
    public void бытовая_техника_Test() {
        // 1. Открыть Яндекс маркет
        actionStep.openYandexMarketMainPage();

        // 2. Выбрать категорию "Компьютеры"
        // 3. Выбрать подкатегорию "Ноутбуки"
        actionStep.openCategoryWithSubCategory("Бытовая техника", "Плиты");

        // 4. Добавить первый товар к сравнению
        // 5. добавить второй товар к сравнению
        List<String> selectedProductNames = actionStep.addProductsToCompare(1, 2, 3);

        // 6. Нажать на кнопку сравнить товары
        actionStep.clickToCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        assertionStep.assertThatAddedProductsShouldBeDisplayedOnTheComparePage(selectedProductNames);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        try {
            System.out.println(Runtime.getRuntime().exec("pwd"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
