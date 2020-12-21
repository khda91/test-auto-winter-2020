package ru.levelup.qa.at.design.patterns.singleton;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonExample2Test {

    @Test
    public void testName23() {
        System.out.println("testName23 " + SingletonExample.getInstance().getValue());
    }

}
