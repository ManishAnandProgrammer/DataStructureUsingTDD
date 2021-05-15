package datastructure.recursion.string_questions;

public class ClimbingStairs {
    public static void main(String[] args) {
        climb(0, 5, "");
    }

    public static void climb(int currentStair,int numberOfStairs, String result) {
        if(currentStair == numberOfStairs) {
            System.out.println(result);
            return;
        }

        if(currentStair > numberOfStairs)
            return;

        climb(currentStair+1, numberOfStairs, result+"1");
        climb(currentStair+2, numberOfStairs, result+"2");
        climb(currentStair+3, numberOfStairs, result+"3");
    }
}
