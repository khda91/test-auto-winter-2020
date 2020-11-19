package ru.levelup.qa.at.java.collections.sets;

import ru.levelup.qa.at.java.collections.Person;
import ru.levelup.qa.at.java.collections.PersonWithEquals;

import java.util.HashSet;
import java.util.Set;

public class HashSetPersonObjectExample {

    public static void main(String[] args) {
        hasSetWithPersonWithoutEquals();
        System.out.println();
        System.out.println();
        hasSetWithPersonWithEquals();
    }

    static void hasSetWithPersonWithoutEquals() {
        Set<Person> persons = new HashSet<>();

        persons.add(new Person("Olya", 18));
        persons.add(new Person("Vasya", 23));
        persons.add(new Person("Petya", 20));
        persons.add(new Person("Semyon", 43));
        persons.add(new Person("Olya", 18));
        persons.add(new Person("Tamara", 19));
        persons.add(new Person("Vasya", 23));
        persons.add(new Person("Olya", 18));
        persons.add(new Person("Petya", 20));

        System.out.println(persons);
        System.out.println();

        persons.remove(new Person("Olya", 18));
        System.out.println(persons);
    }

    static void hasSetWithPersonWithEquals() {
        Set<PersonWithEquals> persons = new HashSet<>();

        persons.add(new PersonWithEquals("Olya", 18));
        persons.add(new PersonWithEquals("Vasya", 23));
        persons.add(new PersonWithEquals("Petya", 20));
        persons.add(new PersonWithEquals("Semyon", 43));
        persons.add(new PersonWithEquals("Olya", 18));
        persons.add(new PersonWithEquals("Tamara", 19));
        persons.add(new PersonWithEquals("Vasya", 23));
        persons.add(new PersonWithEquals("Olya", 18));
        persons.add(new PersonWithEquals("Petya", 20));

        System.out.println(persons);
    }

}
