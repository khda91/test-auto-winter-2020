package ru.levelup.qa.at.design.patterns.builder;

import org.testng.annotations.Test;

public class PersonNonGrataBuilderTest {

    @Test
    public void builderTest() {
        PersonaNonGrate mark = PersonaNonGrate.builder()
                .setTitle("Stastas")
                .setFirstName("Mark")
                .setSecondName("Second")
                .setAge(15)
                .build();

        Person yan = Person.builder()
                .setFirstName("Yan")
                .setSecondName("Third")
                .setAddress("UK")
                .build();

        System.out.println(mark);
        System.out.println(yan);
    }
}
