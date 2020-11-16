package ru.levelup.qa.at.java.enums;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlanetExample {

    public static void main(String[] args) {
        System.out.println(Planet.EARTH.getRuName());

        System.out.println(Arrays.toString(Planet.values()));

        System.out.println(Planet.valueOf("EARTH").getRuName());
    }
}
