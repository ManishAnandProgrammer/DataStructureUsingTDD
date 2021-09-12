package datastructure.hashmap_working.overriding_hashcode_equals;

import java.util.Objects;

public class Student {
    private final int rollNo;
    private String name;
    private final Profile profile;

    public Student(final int rollNo,
                   final String name,
                   final Profile profile) {
        this.rollNo = rollNo;
        this.name = name;
        this.profile = profile;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && name.equals(student.name) && profile.equals(student.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name, profile);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", profile=" + profile +
                '}';
    }
}
