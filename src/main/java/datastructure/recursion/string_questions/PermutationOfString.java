package datastructure.recursion.string_questions;

public class PermutationOfString {
    public static void main(String[] args) {
        permute("abc", "");
    }

    private static void permute(final String question, final String answer) {
        if(question.length() == 0) {
            System.out.println(answer);
            return;
        }

        for(int i = 0; i < question.length(); i++) {
            String newQuestion = question.substring(0, i) + question.substring(i+1);
            String newAnswer = answer + question.charAt(i);

            permute(newQuestion, newAnswer);
        }
    }
}
