package ru.levelup.qa.at.java.enums;

public enum Planet {

    MERCURY("Меркурий", "Mercury"),
    EARTH("Земля", "Earth");

    private String ruName;
    private String engName;

    Planet(String ruName, String engName) {
        this.ruName = ruName;
        this.engName = engName;
    }

    public String getRuName() {
        return ruName;
    }

    public String getEngName() {
        return engName;
    }
}
