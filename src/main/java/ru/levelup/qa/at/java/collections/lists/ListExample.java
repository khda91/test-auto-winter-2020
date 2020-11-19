package ru.levelup.qa.at.java.collections.lists;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("mama");
        list.add("papa");
        list.add("lock");
        print(list);

        list.add(2, "knock");
        print(list);

        list.remove("lock");
        print(list);

        System.out.println(list.get(0));

        list.addAll(list);
        print(list);
    }

    static void print(List<String> list) {
        System.out.println("================");
        System.out.println(list);
        System.out.println("================");
        System.out.println();
    }
}
