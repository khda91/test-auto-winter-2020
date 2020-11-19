package ru.levelup.qa.at.java.collections.maps;

import ru.levelup.qa.at.java.collections.PersonWithComparable;
import ru.levelup.qa.at.java.collections.PersonWithEquals;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapObjectExample {

    public static void main(String[] args) {
        treeMapObjectComparator();
        System.out.println();
        System.out.println();
        System.out.println();
        treeMapObjectComparable();
    }

    static void treeMapObjectComparator() {
        Comparator<PersonWithEquals> comparator = new Comparator<PersonWithEquals>() {
            @Override
            public int compare(PersonWithEquals o1, PersonWithEquals o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return o1.getAge() - o2.getAge();
                }
                return o1.getName().compareTo(o2.getName());
            }
        };

        Map<PersonWithEquals, PersonWithEquals> map = new TreeMap<>(comparator);
        map.put(new PersonWithEquals("Ival", 19), new PersonWithEquals("Olya", 18));
        map.put(new PersonWithEquals("Ival", 23), new PersonWithEquals("Olya", 18));
        map.put(new PersonWithEquals("vasya", 23), new PersonWithEquals("Olya", 18));
        map.put(new PersonWithEquals("Sveat", 20), new PersonWithEquals("Evgeniy", 22));
        map.put(new PersonWithEquals("Oleg", 45), new PersonWithEquals("Varya", 43));
        map.put(new PersonWithEquals("Oleg", 34), new PersonWithEquals("Olya", 35));

        System.out.println(map);
    }

    static void treeMapObjectComparable() {
        Map<PersonWithComparable, PersonWithComparable> map = new TreeMap<>();
        map.put(new PersonWithComparable("Ival", 19), new PersonWithComparable("Olya", 18));
        map.put(new PersonWithComparable("Ival", 23), new PersonWithComparable("Olya", 18));
        map.put(new PersonWithComparable("vasya", 23), new PersonWithComparable("Olya", 18));
        map.put(new PersonWithComparable("Sveat", 20), new PersonWithComparable("Evgeniy", 22));
        map.put(new PersonWithComparable("Oleg", 45), new PersonWithComparable("Varya", 43));
        map.put(new PersonWithComparable("Oleg", 34), new PersonWithComparable("Olya", 35));

        System.out.println(map);
    }
}
