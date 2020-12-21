package ru.levelup.qa.at.design.patterns.builder;

public class Person {

    private final String firstName;
    private final String secondName;
    private final int age;
    private final String phone;
    private final String address;

    protected Person(String firstName, String secondName, int age, String phone, String address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder<B extends Builder<B>> {

        protected String firstName;
        protected String secondName;
        protected int age;
        protected String phone;
        protected String address;

        public B setFirstName(String firstName) {
            this.firstName = firstName;
            return (B) this;
        }

        public B setSecondName(String secondName) {
            this.secondName = secondName;
            return (B) this;
        }

        public B setAge(int age) {
            this.age = age;
            return (B) this;
        }

        public B setPhone(String phone) {
            this.phone = phone;
            return (B) this;
        }

        public B setAddress(String address) {
            this.address = address;
            return (B) this;
        }

        public Person build() {
            return new Person(firstName, secondName, age, phone, address);
        }
    }
}
