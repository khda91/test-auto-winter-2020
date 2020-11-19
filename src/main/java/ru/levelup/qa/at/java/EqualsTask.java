package ru.levelup.qa.at.java;

public class EqualsTask {

    public static void main(String[] args) {
        String str1 = "mama";
        String str2 = "mama";
        String str3 = new String("mama");

        System.out.println("str1 == str2 -> " + (str1 == str2));  // true
        System.out.println("str1.equals(str2) -> " + (str1.equals(str2))); //true
        System.out.println("========");
        System.out.println("str1 == str3 -> " + (str1 == str3)); // false
        System.out.println("str1.equals(str3) -> " + (str1.equals(str3))); // true
    }

}
