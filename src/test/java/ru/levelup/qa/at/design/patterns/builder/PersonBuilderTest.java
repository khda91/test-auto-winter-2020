package ru.levelup.qa.at.design.patterns.builder;

import org.testng.annotations.Test;
import ru.levelup.qa.at.design.patterns.builder.Person;

public class PersonBuilderTest {

    @Test
    public void builderTest() {
        Person mark = Person.builder()
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
