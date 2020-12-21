package ru.levelup.qa.at.design.patterns.builder;

public class PersonaNonGrate extends Person {

    private final String title;

    public PersonaNonGrate(String firstName, String secondName, int age, String phone, String address, String title) {
        super(firstName, secondName, age, phone, address);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "PersonaNonGrate{" +
                "title='" + title + '\'' +
                '}';
    }

    public static class Builder extends Person.Builder<Builder> {

        private String title;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        @Override
        public PersonaNonGrate build() {
            return new PersonaNonGrate(firstName, secondName, age, phone, address, title);
        }
    }
}
