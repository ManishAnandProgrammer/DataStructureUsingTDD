package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CustomArrayListTest {

    private CustomArrayList arrayList;

    @BeforeEach
    void init() {
        arrayList = new CustomArrayList();
    }

    @Test
    @DisplayName("Instance Creation Test")
    void shouldCreateCustomArrayListObject() {
        assertNotNull(arrayList, "CustomArrayList Object should created..!");
    }

    @Test
    @DisplayName("Should Return True If There is No Element Added In List")
    void shouldReturnEmptyTrueIfNoElementAdded() {
        assertTrue(arrayList.isEmpty(), "should return true");
    }

    @Test
    @DisplayName("Should Return False If There is Any Element Present In List")
    void shouldReturnEmptyFalseIfElementAdded() {
        arrayList.add("manish");
        assertFalse(arrayList.isEmpty(), "should return false");
    }

    @Test
    @DisplayName("Add Element In List")
    void shouldAddElementInList() {
        assertTrue(arrayList.add("manish"), "Should Able to add Element In List..!");
    }

    @Test
    @DisplayName("Should Return manish on get(0) call when only one element with manish in list")
    void shouldGetFirstStringAsManishOnFirstGetCall() {
        arrayList.add("manish");
        assertEquals("manish", arrayList.get(0), "First Value Should Be Manish..!");
    }

    @Test
    @DisplayName("Should Return anand on get(1) call when anand added to list on index 1")
    void shouldGetFirstStringAsAnandOnSecondGetCall() {
        arrayList.add("manish");
        arrayList.add("anand");
        assertEquals("anand", arrayList.get(1), "Second Value Should Be Anand..!");
    }

    @ParameterizedTest
    @MethodSource("sizeOf_11_List")
    void shouldBeAbleToAdd_MoreThan_10_Elements_InInitialSizeList_WhenInitialSizeIs_10(List<String> list) {
        IntStream.range(0, 10)
                .forEach(index -> arrayList.add(list.get(index)));
        String eleventh_String = list.get(10);
        boolean addOperationResult = arrayList.add(eleventh_String);
        assertTrue(addOperationResult, "Custom List Should increase it's size and add the Eleventh element");
    }

    static Stream<Arguments> sizeOf_11_List() {
        return Stream.of(arguments(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")));
    }

    @Test
    void shouldThrowExceptionIfNegativeIndexProvidedToGetElement() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1),
                "Method Should Throw IndexOutOfBoundsException if negative Index Provided..!");
    }

    @Test
    void shouldThrowExceptionIfBiggerIndexThanCapacityProvidedToGetElement() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(11),
                "Method Should Throw IndexOutOfBoundsException if Bigger Than Initial Capacity index Provided..!");
    }
}
