package datastructure.strings;

public class StringMethodsWorking {
    public static void main(String[] args) {
        toUpperCaseTesting();
    }

    private static void toUpperCaseTesting() {
        String name = "manish";

        String nameUpperCased_1 = name.toUpperCase();
        String nameUpperCased_2 = name.toUpperCase();

        // toUpperCase() returns object from heap
        System.out.println(nameUpperCased_1 == nameUpperCased_2);
    }
}
