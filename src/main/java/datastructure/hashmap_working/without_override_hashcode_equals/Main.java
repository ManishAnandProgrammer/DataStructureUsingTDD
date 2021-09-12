package datastructure.hashmap_working.without_override_hashcode_equals;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Profile manishProfile = new Profile("manishjangra365@gmail.com", "panipat");
        Student manish = new Student(1, "Manish", manishProfile);

        Profile neerajProfile = new Profile("neeraj@gmail.com", "panipat");
        Student neeraj = new Student(2, "Neeraj", neerajProfile);

        Profile duplicateManishProfile = new Profile("manishjangra365@gmail.com", "panipat");
        Student duplicateManish = new Student(1, "Manish", duplicateManishProfile);

        System.out.println("Manish hashcode " + manish.hashCode());
        System.out.println("Neeraj hashcode " + neeraj.hashCode());
        System.out.println("Duplicate Manish hashcode " + duplicateManish.hashCode());

        System.out.println(manish);
        System.out.println(neeraj);
        System.out.println(duplicateManish);

        HashMap<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(manish, manish.getRollNo());
        studentMap.put(neeraj, neeraj.getRollNo());
        studentMap.put(duplicateManish, duplicateManish.getRollNo());

        System.out.println(studentMap);
    }
}
