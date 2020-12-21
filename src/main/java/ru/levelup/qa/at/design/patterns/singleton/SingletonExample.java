package ru.levelup.qa.at.design.patterns.singleton;

public class SingletonExample {

    private static final SingletonExample INSTANCE = new SingletonExample();

    private String value;

    private SingletonExample() {
    }

    public static SingletonExample getInstance() {
        return INSTANCE;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
