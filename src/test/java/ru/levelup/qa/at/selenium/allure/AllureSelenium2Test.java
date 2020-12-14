package ru.levelup.qa.at.selenium.allure;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.selenium.allure.steps.ActionStep;
import ru.levelup.qa.at.selenium.allure.steps.AssertionStep;

import java.util.List;

@Epic("Сравнение товаров")
@Feature("Сравнение товаров 1")
@Story("Категория электроника")
public class AllureSelenium2Test extends AbstractSeleniumBaseTest {

    private ActionStep actionStep;
    private AssertionStep assertionStep;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка добавления к сравнению товаров из категории электроника")
    @TmsLink("QAAT-40")
    @Issues({@Issue("QAAT-41"), @Issue("QAAT-45")})
    public void электроника_Test() {
        // 1. Открыть Яндекс маркет
        actionStep.openYandexMarketMainPage();

        // 2. Выбрать категорию "Компьютеры"
        // 3. Выбрать подкатегорию "Ноутбуки"
        actionStep.openCategoryWithSubCategory("Электроника", "Смартфоны");

        // 4. Добавить первый товар к сравнению
        // 5. добавить второй товар к сравнению
        List<String> selectedProductNames = actionStep.addProductsToCompare(1, 2);

        // 6. Нажать на кнопку сравнить товары
        actionStep.clickToCompareButton();

        //7. Проверить, что выбранные товары были добавлены к сравнению
        assertionStep.assertThatAddedProductsShouldBeDisplayedOnTheComparePage(selectedProductNames);
    }

}
