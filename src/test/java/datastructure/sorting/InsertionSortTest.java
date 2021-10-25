package datastructure.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortTest {
    private InsertionSort insertionSort;

    @BeforeEach
    void init() {
        insertionSort = new InsertionSort();
    }

    @Test
    void sort() {
        int[] array = {10, 12, 4, 65, 23, 44, 73};
        insertionSort.sortIt(array);

        Arrays.stream(array).forEach(System.out::println);
    }
}
