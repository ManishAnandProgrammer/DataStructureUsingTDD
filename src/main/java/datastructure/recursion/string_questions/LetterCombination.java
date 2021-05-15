package datastructure.recursion.string_questions;

import java.util.Map;

public class LetterCombination {
    private static final Map<Character, String> codeMap =
            Map.of('2', "abc",
                    '3', "def",
                    '4', "ghi",
                    '5', "jkl",
                    '6', "mno",
                    '7', "pqrs",
                    '8', "tuv",
                    '9', "wxyz");

    public static void main(String[] args) {
        //combinations("abc", "def");
        //combinationRecursive("abc", "def", "");
        leetCodeLetterCombo("234", "");
    }

    private static void combinations(String first, String second) {
        for(int i = 0; i < first.length(); i++) {
            for(int j = 0; j < second.length(); j++) {
                System.out.println(""+first.charAt(i) + second.charAt(j));
            }
        }
    }

    private static void combinationRecursive(String first, String second, String result) {
        if(result.length() == 2) {
            System.out.println(result);
            return;
        }

        for(int i = 0; i < first.length(); i++) {
            combinationRecursive(second, "", result+first.charAt(i));
        }
    }

    private static void leetCodeLetterCombo(String numberPressed, String result) {
        if(numberPressed.length() == 0) {
            System.out.println(result);
            return;
        }

        char code = numberPressed.charAt(0);
        String restOfTheNumberPressed = numberPressed.substring(1);

        String valueOfCode = getValueOfCode(code);

        for(int i = 0; i < valueOfCode.length(); i++) {
            leetCodeLetterCombo(restOfTheNumberPressed, result+valueOfCode.charAt(i));
        }
    }

    private static String getValueOfCode(char code) {
        return codeMap.get(code);
    }
}
