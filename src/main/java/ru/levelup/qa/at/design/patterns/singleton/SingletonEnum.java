package ru.levelup.qa.at.design.patterns.singleton;

public enum SingletonEnum {

    INSTANCE;

    private String value;

    SingletonEnum() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
