package datastructure.recursion.string_questions;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintAllPalindrome
{
	public static void main(String[] args) {
		allPalPartitions("nitin");
	}

	private static void allPalPartitions(String input) {
		int inputStringLength = input.length();
		ArrayList<ArrayList<String>> allPartition = new ArrayList<>();
		Deque<String> currPartition = new LinkedList<>();
		allPalindromePartitions(allPartition, currPartition, 0, inputStringLength, input);

		for (int i = 0; i < allPartition.size(); i++) {
			for (int j = 0; j < allPartition.get(i).size(); j++) {
				System.out.print(allPartition.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

	private static void allPalindromePartitions(ArrayList<ArrayList<String>> parentList,
												Deque<String> currentChildList, int startIndex, int lengthOfInput, String input)
	{
		if (startIndex >= lengthOfInput) {
			parentList.add(new ArrayList<>(currentChildList));
			return;
		}

		for (int i = startIndex; i < lengthOfInput; i++) {
			if (isPalindrome(input, startIndex, i)) {
				currentChildList.addLast(input.substring(startIndex, i + 1));
				allPalindromePartitions(parentList, currentChildList, i + 1, lengthOfInput, input);
				currentChildList.removeLast();
			}
		}
	}

	private static boolean isPalindrome(String input,
									int start, int end) {
		while (start < end) {
			if (input.charAt(start++) != input.charAt(end--))
				return false;
		}
		return true;
	}
}
