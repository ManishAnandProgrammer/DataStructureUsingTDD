package datastructure;

public class CustomArrayList {
    private int size;
    private String[] strings = new String[10];

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(final String value) {
        strings[size] = value;
        size++;
        return true;
    }

    public String get(int index) {
        return strings[index];
    }
}
