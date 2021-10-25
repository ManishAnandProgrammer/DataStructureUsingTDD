package datastructure.sorting;

public class InsertionSort {

    public void sortIt(int[] unsortedArray) {
        int arrayLength = unsortedArray.length;

        for(int i = 1; i < arrayLength; i++) {
            int number = unsortedArray[i];

            int j = i;
            while(j > 0 && unsortedArray[j - 1] > number) {
                unsortedArray[j] = unsortedArray[j - 1];
                j--;
            }
            unsortedArray[j] = number;
        }
    }
}
