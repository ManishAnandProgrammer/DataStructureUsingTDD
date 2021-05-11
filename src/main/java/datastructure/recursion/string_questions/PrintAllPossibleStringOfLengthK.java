package datastructure.recursion.string_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllPossibleStringOfLengthK {

    public static void main(String[] args) {
        char[] characters = {'a', 'b'};
        int stringLength = 4;
        printAllKLengthRecUsingLoop(characters, stringLength);
        printAllKLengthRec(characters, "", characters.length, stringLength);
    }

    static void printAllKLengthRec(char[] set, String prefix, int numberOfChars, int stringLength) {
        if (stringLength == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < numberOfChars; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix,
                    numberOfChars, stringLength - 1);
        }
    }

    static void printAllKLengthRecUsingLoop(char[] set, int stringLength) {
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < set.length; i++) {
            Stack<String> stack = new Stack<>();
            stack.push("" + set[i]);

            int temp = stringLength-1;
            while(temp > 0) {
                List<String> tempList = new ArrayList<>();
                while(!stack.empty()) {
                    tempList.add(stack.pop());
                }
                for(String prefix: tempList) {
                    for(int j = 0; j < set.length; j++) {
                        stack.push(prefix + set[j]);
                    }
                }
                temp--;
            }
            strings.addAll(stack);
        }
        System.out.println(strings);
    }

}
