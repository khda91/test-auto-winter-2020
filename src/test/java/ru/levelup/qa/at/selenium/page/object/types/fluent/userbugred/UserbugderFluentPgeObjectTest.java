package ru.levelup.qa.at.selenium.page.object.types.fluent.userbugred;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;
import ru.levelup.qa.at.selenium.page.object.types.fluent.bugred.UserBugredHomePage;
import ru.levelup.qa.at.selenium.page.object.types.fluent.bugred.UserBugredLoginRegistrationPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserbugderFluentPgeObjectTest extends AbstractSeleniumBaseTest {

    @Test
    public void registrationSuccessTest() {
        driver.get("http://users.bugred.ru/");
        UserBugredLoginRegistrationPage loginRegistrationPage = new UserBugredHomePage(driver)
                .enterButtonClick();

        UserBugredHomePage homePage = loginRegistrationPage
                .fillRegistrationUserNameTextField(RandomStringUtils.randomAlphabetic(10))
                .fillRegistrationEmailTextField(RandomStringUtils.randomAlphabetic(5) + "@email.com")
                .fillRegistrationPasswordTextField("test")
                .successRegistrationButtonClick();

        assertThat(homePage.isUserButtonDisplayed(), is(true));
    }

    @Test
    public void registrationFailedTest() {
        driver.get("http://users.bugred.ru/");
        UserBugredLoginRegistrationPage loginRegistrationPage = new UserBugredHomePage(driver)
                .enterButtonClick()
                .fillRegistrationUserNameTextField("testsddsasdjvkdashf")
                .fillRegistrationEmailTextField(RandomStringUtils.randomAlphabetic(5) + "@email.com")
                .fillRegistrationPasswordTextField("test")
                .failedRegistrationButtonClick();

        assertThat(loginRegistrationPage.getRegistrationErrorMessageText(), equalTo(""));
    }

}
