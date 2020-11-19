package ru.levelup.qa.at.java.collections.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
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

        List<String> list  = Arrays.asList("abba", "u2", "lordi", "lordi");
        set.addAll(list);
        System.out.println(set);
        System.out.println("===========");
        System.out.println();

        Set<String> strings = new TreeSet<>(list);
        System.out.println(strings);
        System.out.println("===========");
        System.out.println();
    }

    static Collection<String> getCollection() {
        return new LinkedList<>();
    }

}
