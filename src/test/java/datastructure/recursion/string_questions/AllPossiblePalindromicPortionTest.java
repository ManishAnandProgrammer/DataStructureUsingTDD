package datastructure.recursion.string_questions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AllPossiblePalindromicPortionTest {

//    @ParameterizedTest
//    @MethodSource("palindromicPortion")
//    void test(String value, List<List<String>> expectedPalindromicPortions) {
//        AllPossiblePalindromicPortion palindromicPortion = new AllPossiblePalindromicPortion();
//        List<List<String>> actualPalindromicPortions =
//                palindromicPortion.palindromicPortionOf(value);
//
//        assertThat(actualPalindromicPortions).containsExactlyInAnyOrderElementsOf(expectedPalindromicPortions);
//    }

    static Stream<Arguments> palindromicPortion() {
        return Stream.of(
          arguments("nitin", List.of(List.of("n", "i", "t", "i", "n"), List.of("n", "iti", "n"), List.of("nitin"))),
          arguments("geeks", List.of(List.of("g", "e", "e", "k", "s"), List.of("g", "ee", "k", "s")))
        );
    }
}