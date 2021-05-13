package datastructure.recursion.string_questions;

public class CoinToss {
    public static void main(final String[] args) {
        toss(4, "");
    }

    public static void toss(final int numberOfTimes, final String result) {
        if(numberOfTimes == 0) {
            System.out.println(result);
            return;
        }

        toss(numberOfTimes - 1, result+"H");
        toss(numberOfTimes - 1, result+"T");
    }
}
