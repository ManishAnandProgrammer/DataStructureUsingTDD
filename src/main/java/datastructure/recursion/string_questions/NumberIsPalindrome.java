package datastructure.recursion.string_questions;

public class NumberIsPalindrome {

    public boolean isPalindromeNumberUsingString(int number) {
        String numberInString = number + "";
        StringBuilder numberInBuilder = new StringBuilder(numberInString);
        String reverseNumber = numberInBuilder.reverse().toString();
        return numberInString.equals(reverseNumber);
    }

    public boolean isPalindromeNumberUsingWhile(int number) {
       int reverseNumber = 0;
       int remainder;
       int originalNumber = number;

       while(number != 0) {
           remainder = number % 10;
           reverseNumber = reverseNumber * 10 + remainder;
           number /= 10;
       }

       return originalNumber == reverseNumber;
    }

    public boolean isPalindromeNumberUsingRecursion(int number) {
        return number == reverse(number, 0);
    }


    private int reverse(int number, int temp) {
        if (number == 0)
            return temp;

        temp = (temp * 10) + (number % 10);
        return reverse(number / 10, temp);
    }
}
