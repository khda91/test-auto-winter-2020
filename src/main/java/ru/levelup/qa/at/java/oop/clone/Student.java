package ru.levelup.qa.at.java.oop.clone;

public class Student extends Person {

    private String dateOfBirth;

    public Student(String name, String email, String dateOfBirth) {
//        super(name, email);
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return dateOfBirth != null ? dateOfBirth.equals(student.dateOfBirth) : student.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }
}
