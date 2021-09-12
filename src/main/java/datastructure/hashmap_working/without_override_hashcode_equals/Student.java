package datastructure.hashmap_working.without_override_hashcode_equals;

public class Student {
    private final int rollNo;
    private final String name;
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

}
