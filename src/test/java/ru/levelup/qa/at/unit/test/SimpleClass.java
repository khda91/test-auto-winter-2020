package ru.levelup.qa.at.unit.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleClass {

    @Test
    public void testSimple() {
        System.out.println("testSimpleClass");
        Assert.assertEquals(2 + 2, 4);
    }
}
