package datastructure.sorting;

import java.util.Arrays;

public class CollectionSorting {
    public static void main(String[] args) {
        sortArrayUsingArraysClass();
    }

    private static void sortArrayUsingArraysClass() {
        int[] array = {32, 1, 43, 54, 4, 65, 23, 85, 3, 345};
        System.out.println("Before Sorting");
        printArray(array);

        Arrays.sort(array);

        System.out.println("After Sorting");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int number: array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
