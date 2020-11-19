package ru.levelup.qa.at.java.collections.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("vovo");
        set.add("baba");

        System.out.println(set);
        System.out.println("===========");
        System.out.println();

        set.add("mama");
        set.add("baba");

        System.out.println(set);
        System.out.println("===========");
        System.out.println();

        set.remove("baba");

        System.out.println(set);
        System.out.println("===========");
        System.out.println();

        System.out.println(new ArrayList<>(set).get(1));
        System.out.println("===========");
        System.out.println();

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===========");
        System.out.println();
    }

}
