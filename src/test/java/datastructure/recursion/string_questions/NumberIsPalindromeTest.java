package datastructure.recursion.string_questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberIsPalindromeTest {

    private NumberIsPalindrome numberIsPalindrome;

    @BeforeEach
    void setUp() {
        numberIsPalindrome = new NumberIsPalindrome();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 101, 1001, 1221, 434, 444})
    void isPalindrome(int number) {
        assertTrue(numberIsPalindrome.isPalindromeNumberUsingString(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 1012, 10012, 13221, 4534, 4454})
    void isNotPalindrome(int number) {
        assertFalse(numberIsPalindrome.isPalindromeNumberUsingString(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 101, 1001, 1221, 434, 444})
    void isPalindromeUsingWhile(int number) {
        assertTrue(numberIsPalindrome.isPalindromeNumberUsingWhile(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 1012, 10012, 13221, 4534, 4454})
    void isNotPalindromeUsingWhile(int number) {
        assertFalse(numberIsPalindrome.isPalindromeNumberUsingWhile(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 101, 1001, 1221, 434, 444})
    void isPalindromeUsingRecursion(int number) {
        assertTrue(numberIsPalindrome.isPalindromeNumberUsingRecursion(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 1012, 10012, 13221, 4534, 4454})
    void isNotPalindromeUsingRecursion(int number) {
        assertFalse(numberIsPalindrome.isPalindromeNumberUsingRecursion(number));
    }
}