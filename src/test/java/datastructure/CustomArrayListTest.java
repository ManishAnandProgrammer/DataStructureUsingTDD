package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldGetFirstStringAsManishOnFirstGetCall() {
        arrayList.add("manish");
        assertEquals("manish", arrayList.get(0), "First Value Should Be Manish..!");
    }

    @Test
    void shouldGetFirstStringAsAnandOnSecondGetCall() {
        arrayList.add("manish");
        arrayList.add("anand");
        assertEquals("anand", arrayList.get(1), "Second Value Should Be Anand..!");
    }

}
