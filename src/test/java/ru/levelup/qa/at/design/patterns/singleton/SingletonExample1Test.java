package ru.levelup.qa.at.design.patterns.singleton;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonExample1Test {

    @BeforeMethod
    public void setUp() {
        SingletonExample.getInstance().setValue("setUp");
    }

    @Test
    public void testName() {
        System.out.println("testName " + SingletonExample.getInstance().getValue());
    }

    @Test
    public void testName1() {
        System.out.println("testName1 " + SingletonExample.getInstance().getValue());
        SingletonExample.getInstance().setValue("testName1");
//        SingletonExample singletonExample = new SingletonExample(); пытаемся вызвать приватный конструктор
    }
}
