package datastructure.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("On Checking Factorial")
public class FactorialFinderTest {

    @ParameterizedTest
    @DisplayName("of a number")
    @MethodSource("numberAndFactorial")
    void factorialTest(int number, int expectedFactorial) {
        FactorialFinder factorialFinder = new FactorialFinder();
        assertEquals(expectedFactorial, factorialFinder.factorialOf(number), "should return expected factorial");
    }

    static Stream<Arguments> numberAndFactorial() {
        return Stream.of(
                arguments(0, 1),
                arguments(1, 1),
                arguments(2, 2),
                arguments(3, 6),
                arguments(4, 24),
                arguments(5, 120),
                arguments(6, 720)
        );
    }
}
