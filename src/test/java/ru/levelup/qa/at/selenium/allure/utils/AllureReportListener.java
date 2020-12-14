package ru.levelup.qa.at.selenium.allure.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.levelup.qa.at.selenium.AbstractSeleniumBaseTest;

import java.time.LocalDateTime;

public class AllureReportListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(dateToString());
    }

    @Attachment(value = "{0}", fileExtension = ".png", type = "image/png")
    private byte[] takeScreenshot(String timestamp) {
        byte[] screenshot;
        TakesScreenshot takesScreenshot = (TakesScreenshot) AbstractSeleniumBaseTest.getDriver();
        screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    private String dateToString() {
        return LocalDateTime.now().toString();
    }
}
