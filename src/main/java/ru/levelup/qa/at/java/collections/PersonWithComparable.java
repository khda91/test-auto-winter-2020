package ru.levelup.qa.at.java.collections;

public class PersonWithComparable implements Comparable<PersonWithComparable> {

    private String name;
    private int age;

    public PersonWithComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonWithComparable that = (PersonWithComparable) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "PersonWithComparable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(PersonWithComparable o) {
        if (this.getName().compareTo(o.getName()) == 0) {
            return this.getAge() - o.getAge();
        }
        return this.getName().compareTo(o.getName());
    }
}
