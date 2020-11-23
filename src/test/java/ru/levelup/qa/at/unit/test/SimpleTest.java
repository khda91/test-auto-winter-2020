package ru.levelup.qa.at.unit.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void testSimple() {
        System.out.println("testSimple");
        Assert.assertEquals(2 + 2, 4);
    }
}
