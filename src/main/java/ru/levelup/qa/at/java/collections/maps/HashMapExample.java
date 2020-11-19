package ru.levelup.qa.at.java.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("mama", "papa");
        map.put("son", "docha");
        map.put("baba", "deda");
        map.put("son", "docha");

        System.out.println(map);
        System.out.println();

        map.put("baba", "pra-vnuk");
        System.out.println(map);
        System.out.println();

        for (String key : map.keySet()) {
            System.out.println(key + " || " + map.get(key));
        }
        System.out.println();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " || " + entry.getValue());
        }
        System.out.println();
    }
}
