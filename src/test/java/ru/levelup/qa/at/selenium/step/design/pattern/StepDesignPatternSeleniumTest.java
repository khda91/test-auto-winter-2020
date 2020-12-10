package ru.levelup.qa.at.selenium.step.design.pattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.selenium.step.design.pattern.steps.ActionStep;
import ru.levelup.qa.at.selenium.step.design.pattern.steps.AssertionStep;

import java.util.List;

public class StepDesignPatternSeleniumTest extends AbstractSeleniumBaseTest {

    private ActionStep actionStep;
    private AssertionStep assertionStep;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @Test
    public void sampleStepDesignPatternTest() {
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
        assertionStep.assertThatAddedProductsShouldBeDisplayedOnTheComparePage(selectedProductNames);
    }

}
