package datastructure.strings;

public class InternMethodWorking {
    public static void main(String[] args) {
        String first = "hello world";
        String firstInterned = first.intern();

        System.out.println(first == firstInterned);

        String second = new String("hello manish");
        String secondInterned = second.intern();

        System.out.println(second == secondInterned);

        String third = "hello manish";
        System.out.println(secondInterned == third);
    }
}
