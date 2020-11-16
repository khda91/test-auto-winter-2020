package ru.levelup.qa.at.java.overload;

public class Example {

    public static void print() {
        System.out.println("");
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(String str, int i) {
        System.out.println(str + " " + i);
    }

    public static void print(int i, String str) {
        System.out.println(i + " " + str);
    }

    public static int print(int i, int j) {
        System.out.println(i);
        return i;
    }

    public static double print(double j) {
        System.out.println(j);
        return j;
    }

    public static void main(String[] args) {
        print();
        print(1);
        print("Hello", 1);
        print(1, "Hello");

        print(2D);
    }

}
