package ru.levelup.qa.at.java.oop.interfaces.extend;

import java.io.Serializable;

public class DoWork extends Object implements DoItPlus, Serializable, AutoCloseable {

    public void doSomething() {

    }

    public int doSomethingElse(int i) {
        return 0;
    }

    public boolean didiItWorks() {
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
