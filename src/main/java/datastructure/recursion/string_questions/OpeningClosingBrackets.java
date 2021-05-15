package datastructure.recursion.string_questions;

public class OpeningClosingBrackets {
    public static void main(String[] args) {
        bracket(3, 0, 0, "");
    }

    public static void bracket(int numberOfBrackets, int opening, int closing, String result) {
        if(closing > opening)
            return;

        if(opening > numberOfBrackets || closing > numberOfBrackets)
            return;

        if(opening == numberOfBrackets && closing == numberOfBrackets) {
            System.out.println(result);
            return;
        }

        bracket(numberOfBrackets,  opening+1, closing, result + "(");
        bracket(numberOfBrackets,  opening, closing+1, result + ")");
    }
}
