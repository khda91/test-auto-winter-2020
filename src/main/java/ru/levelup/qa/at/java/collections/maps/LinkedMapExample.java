package ru.levelup.qa.at.java.collections.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("mama", "papa");
        map.put("son", "docha");
        map.put("baba", "deda");
        map.put("son", "docha");

        System.out.println(map);
        System.out.println();

        map.put("baba", "pra-vnuk");
        System.out.println(map);
        System.out.println();
    }
}
