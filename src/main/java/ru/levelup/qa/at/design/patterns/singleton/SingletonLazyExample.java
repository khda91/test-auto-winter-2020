package ru.levelup.qa.at.design.patterns.singleton;

public class SingletonLazyExample {
    private static SingletonLazyExample instance;

    private String value;

    private SingletonLazyExample() {
    }

    public static SingletonLazyExample getInstance() {
        if (instance == null) {
            instance = new SingletonLazyExample();
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
