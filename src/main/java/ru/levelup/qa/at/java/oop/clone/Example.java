package ru.levelup.qa.at.java.oop.clone;

public class Example {

    public static void main(String[] args) {
        Person p = new Person("Vasya", "");
        Object o = new Person("Petya", "");
        Person s = new Student("Sergey", "", "01.01.2020");

        System.out.println(((Student) s).getDateOfBirth());
    }
}
