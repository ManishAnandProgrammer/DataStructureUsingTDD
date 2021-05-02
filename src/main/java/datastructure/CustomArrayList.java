package datastructure;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int size;
    private String[] strings = new String[DEFAULT_INITIAL_CAPACITY];
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(final String value) {
        if(capacity > size) {
            strings[size] = value;
            size++;
            return true;
        } else {
            extendCapacity();
            return add(value);
        }
    }

    private void extendCapacity() {
        strings = copyOldArrayValuesInNewBiggerArray();
        capacity = strings.length;
    }

    private String[] copyOldArrayValuesInNewBiggerArray() {
        String[] newArray = new String[strings.length * 2];
        System.arraycopy(strings, 0, newArray, 0, capacity);
        return newArray;
    }

    public String get(int index) {
        Objects.checkIndex(index, size);
        return strings[index];
    }

    public String remove(int index) {
        Objects.checkIndex(index, size);
        return removeItem(index);
    }

    private String removeItem(int index) {
        String itemToRemove = get(index);
        if(index < size) {
            for(int i = index; i < size; i++) {
                strings[i] = strings[i+1];
            }
        }
        size--;
        return itemToRemove;
    }

    public int size() {
        return size;
    }

}
