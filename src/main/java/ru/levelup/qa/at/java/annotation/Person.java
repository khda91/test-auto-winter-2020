package ru.levelup.qa.at.java.annotation;

import java.lang.reflect.Field;

public class Person {

    @MyCustomAnnotation("sss")
    private String name;

    public Person() {
        initName();
    }

    public Person(String name) {
        this.name = name;
        initName();
    }

    public String getName() {
        return name;
    }

    private void initName() {
        if (this.name == null || this.name.isEmpty()) {
            try {
                Field name = this.getClass().getDeclaredField("name");
                if (name.isAnnotationPresent(MyCustomAnnotation.class)) {
                    MyCustomAnnotation annotation = name.getAnnotation(MyCustomAnnotation.class);
                    this.name = annotation.value();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
