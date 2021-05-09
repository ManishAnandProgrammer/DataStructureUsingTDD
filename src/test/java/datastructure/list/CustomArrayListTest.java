package datastructure.list;

import datastructure.list.CustomArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("On CustomArrayList when")
public class CustomArrayListTest {

    private CustomArrayList arrayList;

    @BeforeEach
    void init() {
        arrayList = new CustomArrayList();
    }

    @Test
    @DisplayName("creating object")
    void shouldCreateCustomArrayListObject() {
        assertNotNull(arrayList, "CustomArrayList Object should created..!");
    }

    @Test
    @DisplayName("calling isEmpty() on empty list")
    void shouldReturnEmptyTrueIfNoElementAdded() {
        assertTrue(arrayList.isEmpty(), "should return true");
    }

    @Test
    @DisplayName("calling isEmpty() on a list having item")
    void shouldReturnEmptyFalseIfElementAdded() {
        arrayList.add("manish");
        assertFalse(arrayList.isEmpty(), "should return false");
    }

    @Test
    @DisplayName("adding element in list")
    void shouldAddElementInList() {
        assertTrue(arrayList.add("manish"), "Should return true after element added..!");
    }

    @Test
    @DisplayName("calling get(0) with only one item in list")
    void shouldGetFirstStringAsManishOnFirstGetCall() {
        arrayList.add("manish");
        assertEquals("manish", arrayList.get(0), "should return first value manish..!");
    }

    @Test
    @DisplayName("calling get(1) with only two items in list")
    void shouldGetFirstStringAsAnandOnSecondGetCall() {
        arrayList.add("manish");
        arrayList.add("anand");
        assertEquals("anand", arrayList.get(1), "should return second value manish..!");
    }

    @ParameterizedTest
    @MethodSource("sizeOf_11_List")
    @DisplayName("given initial list size 10, trying to add 11th item")
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
    @DisplayName("negative index provided to get element")
    void shouldThrowExceptionIfNegativeIndexProvidedToGetElement() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1),
                "Method Should Throw IndexOutOfBoundsException if negative Index Provided..!");
    }

    @Test
    @DisplayName("bigger index than size provided to get element")
    void shouldThrowExceptionIfBiggerIndexThanSizeProvidedToGetElement() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(11),
                "Method Should Throw IndexOutOfBoundsException if Bigger Than size index Provided..!");
    }

    @ParameterizedTest
    @MethodSource("list_size_check")
    @DisplayName("calling size()")
    void shouldReturnSizeEqualToNumberOfElementsPresentInList(List<String> list) {
        list.forEach(arrayList::add);
        int size = arrayList.size();
        assertEquals(list.size(), size, "Should Give Size as Number of Items in List");
    }

    static Stream<Arguments> list_size_check() {
        return Stream.of(
                    arguments(List.of()),
                    arguments(List.of("a")),
                    arguments(List.of("a", "b")),
                    arguments(List.of("a", "b", "c", "d")),
                    arguments(List.of("a", "b", "c", "d", "e"))
                );
    }

    @ParameterizedTest
    @MethodSource("remove_item_check")
    @DisplayName("remove() method called")
    void shouldRemoveElementAndReturnIt(List<String> list) {
        list.forEach(arrayList::add);

        String lastStringInList = list.get(list.size() -1);
        String removedElement = arrayList.remove(arrayList.size() - 1);
        assertEquals(lastStringInList, removedElement, "Removed Element Should be Returned..!");
    }

    static Stream<Arguments> remove_item_check() {
        return Stream.of(
                arguments(Arrays.asList("a")),
                arguments(Arrays.asList("a", "b")),
                arguments(Arrays.asList("a", "b", "c", "d")),
                arguments(Arrays.asList("a", "b", "c", "d", "e"))
        );
    }

    @ParameterizedTest
    @MethodSource("sizeOf_11_List")
    @DisplayName("remove() method called on 11 size() list")
    void whenRemovedItemFromArraylistOfSize_11_ItShouldReturnSize_10(List<String> list) {
        list.forEach(arrayList::add);

        arrayList.remove(1);
        assertEquals(10, arrayList.size(), "After Removing One Element From 11 size List," +
                " size should be 10");
    }

    @ParameterizedTest
    @MethodSource("shift_elements_on_remove_check")
    @DisplayName("remove() called check shifting items")
    void whenRemoveItemFrom_List_All_Remaining_Item_FromListShould_ShiftLeftOneIndex(List<String> list,
                                                                                          int removeIndex,
                                                                                          String expectedToString) {
        list.forEach(arrayList::add);
        arrayList.remove(removeIndex);

        String[] actualArray = new String[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++)
            actualArray[i] = arrayList.get(i);

        String actual = String.join(", ", actualArray);
        assertEquals(expectedToString, actual, "Items should shift to left");
    }

    static Stream<Arguments> shift_elements_on_remove_check() {
        return Stream.of(
                arguments(List.of("a"), 0, ""),
                arguments(List.of("a", "b"), 1, "a"),
                arguments(List.of("a", "b", "c", "d"), 1, "a, c, d"),
                arguments(List.of("a", "b", "c", "d", "e"), 3, "a, b, c, e"),
                arguments(List.of("a", "b", "c", "d", "e", "f"), 5, "a, b, c, d, e")
        );
    }

    @Test
    @DisplayName("trying to remove element from empty list")
    void whenTryingToRemoveElementFromEmptyListIsShouldThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class , () -> {
           arrayList.remove(0);
        }, "IndexOutOfBoundsException should be thrown here");
    }

    @ParameterizedTest
    @MethodSource("remove_item_check")
    @DisplayName("trying to remove element using bigger than size() index")
    void whenTryingToRemoveElementUsingIndexBiggerThanOrEqualToSizeShouldThrowOutOfBoundException(List<String> list) {
        list.forEach(arrayList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(list.size());
        }, "IndexOutOfBoundsException should be thrown here");
    }

}
