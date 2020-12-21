package ru.levelup.qa.at.design.patterns.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String EDGE = "edge";

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(final String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case CHROME:
                driver = createChromeDriver();
                break;

            case FIREFOX:
                driver = createFirefoxDriver();
                break;

            case EDGE:
                driver = createEdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(String.format("Unable create '%s' web driver. '%s' is unsupported.\n" +
                        "Supported drivers are \n" +
                        "\t* %s\n" +
                        "\t* %s\n" +
                        "\t* %s\n\n", browserName, browserName, CHROME, FIREFOX, EDGE));
        }

        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

}
