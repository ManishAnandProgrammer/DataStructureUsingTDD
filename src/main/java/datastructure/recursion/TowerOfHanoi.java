package datastructure.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        shiftDisks(3, "Source", "Destination", "Helper");
    }

    public static void shiftDisks(int diskNumber, String source, String destination, String helper) {
        if(diskNumber == 0)
            return;

        shiftDisks(diskNumber-1, source, helper, destination);
        System.out.printf("Shifting disk number %d from %s to %s %n", diskNumber, source, destination);
        shiftDisks(diskNumber-1, helper, destination, source);
    }
}
