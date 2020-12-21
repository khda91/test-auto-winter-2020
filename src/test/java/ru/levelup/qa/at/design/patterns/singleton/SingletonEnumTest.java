package ru.levelup.qa.at.design.patterns.singleton;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingletonEnumTest {

    @BeforeClass
    public void setUp() {
        SingletonEnum.INSTANCE.setValue("setUp");
    }

    @Test
    public void testName() {
        System.out.println("testName " + SingletonEnum.INSTANCE.getValue());
    }

    @Test
    public void testName1() {
        System.out.println("testName1 " + SingletonEnum.INSTANCE.getValue());
    }
}
