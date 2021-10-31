package datastructure.strings;

public class InternMethodWorking {
    public static void main(String[] args) {
        String first = "hello world";
        // if pool contains literal than intern()
        // will return that literal reference
        String firstInterned = first.intern();

        // true
        System.out.println(first == firstInterned);

        // second is refering to heap object
        String second = new String("hello manish");

        // secondInterned refering to the pool literal
        String secondInterned = second.intern();

        // false
        System.out.println(second == secondInterned);

        // refering to the pool literal
        String third = "hello manish";

        // true
        System.out.println(secondInterned == third);
    }
}
