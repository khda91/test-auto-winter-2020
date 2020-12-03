package ru.levelup.qa.at.selenium.additional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class TakeScreenshotSeleniumTest extends AbstractSeleniumBaseTest {

    @Test
    public void testScreenshot() throws IOException {
        driver.navigate().to("https://market.yandex.ru");

        TakesScreenshot screenshot = (TakesScreenshot) this.driver;
        File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs, new File("target/screenshots/screenshot_" + LocalDateTime.now() + ".png"));
    }
}
