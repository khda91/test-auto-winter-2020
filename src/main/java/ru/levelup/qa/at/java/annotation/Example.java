package ru.levelup.qa.at.java.annotation;

public class Example {

    public static void main(String[] args) {
        Person p = new Person();
        Person p1 = new Person("p1");
        Person p2 = new Person("");
        Person p3 = new Person(null);
        System.out.println("p " + p.getName());
        System.out.println("p1 " + p1.getName());
        System.out.println("p2 " + p2.getName());
        System.out.println("p3 " + p3.getName());
    }
}
