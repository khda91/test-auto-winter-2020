package ru.levelup.qa.at.selenium.allure.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AllurePropertiesGenerator {

    private static final String ENVIRONMENT_PROPERTIES_FILENAME = "environment.properties";

    private static final String ALLURE_RESULTS_FOLDER = "allure-results";

    public static void createAllureProperties() {
        List<String> properties = new ArrayList<>();

        properties.add("java.version=" + System.getProperty("java.version"));
        properties.add("os.name=" + System.getProperty("os.name"));
        properties.add("my.prop=" + System.getProperty("my.prop"));

        try {
            Path allureResults = Paths.get(ClassLoader.getSystemResource("").toURI()).getParent();
            allureResults = Paths.get(allureResults.toAbsolutePath().toString(), ALLURE_RESULTS_FOLDER, ENVIRONMENT_PROPERTIES_FILENAME);
            if (!Files.exists(allureResults.getParent())) {
                Files.createDirectories(allureResults.getParent());
            }

            Files.write(allureResults, properties, StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
