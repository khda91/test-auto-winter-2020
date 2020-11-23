package ru.levelup.qa.at.unit.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest1 {

    @Test
    public void testSimple() {
        System.out.println("testSimple1");
        Assert.assertEquals(2 + 2, 4);
    }
}
