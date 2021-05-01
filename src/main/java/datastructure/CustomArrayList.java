package datastructure;

public class CustomArrayList {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int size;
    private String[] strings = new String[DEFAULT_INITIAL_CAPACITY];

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(final String value) {
        if(strings.length > size) {
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
    }

    private String[] copyOldArrayValuesInNewBiggerArray() {
        String[] newArray = new String[strings.length * 2];
        for(int i=0; i < strings.length; i++)
            newArray[i] = strings[i];
        return newArray;
    }

    public String get(int index) {
        return strings[index];
    }

}
