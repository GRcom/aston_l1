package ru.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MyOwnArrayListTest {

    private final MyOwnArrayList<Integer> myEmptyOwnArrayList = new MyOwnArrayList<>();
    private final MyOwnArrayList<Integer> myOwnArrayListOfIntegers = new MyOwnArrayList<>();
    private final MyOwnArrayList<String> myOwnArrayListOfStrings = new MyOwnArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10; i++) {
            myOwnArrayListOfIntegers.add(i);
            myOwnArrayListOfStrings.add(String.valueOf(i));
        }
    }

    @Test
    void testAddWithOneArg() {
        myEmptyOwnArrayList.add(1);
        assertEquals("[1]", myEmptyOwnArrayList.toString());
        myEmptyOwnArrayList.add(2);
        assertEquals("[1, 2]", myEmptyOwnArrayList.toString());
        myEmptyOwnArrayList.add(null);
        assertEquals("[1, 2, null]", myEmptyOwnArrayList.toString());
    }

    @Test
    void testIsEmpty() {
        assertTrue(myEmptyOwnArrayList.isEmpty());
        assertFalse(myOwnArrayListOfIntegers.isEmpty());
        assertFalse(myOwnArrayListOfStrings.isEmpty());

    }

    @Test
    void testToString() {
        assertEquals("[]", myEmptyOwnArrayList.toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", myOwnArrayListOfIntegers.toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", myOwnArrayListOfStrings.toString());
    }

    @Test
    void testContains() {
        assertFalse(myEmptyOwnArrayList.contains(1));
        assertTrue(myOwnArrayListOfIntegers.contains(1));
        assertFalse(myOwnArrayListOfIntegers.contains(10));
        assertTrue(myOwnArrayListOfStrings.contains("1"));
        assertFalse(myOwnArrayListOfStrings.contains("10"));
    }

    @Test
    void testRemoveValue() {
        myOwnArrayListOfIntegers.remove(5);
        myOwnArrayListOfStrings.remove(5);

        assertThrows(IndexOutOfBoundsException.class, () -> myEmptyOwnArrayList.remove(5));
        assertEquals("[0, 1, 2, 3, 4, 6, 7, 8, 9]", myOwnArrayListOfIntegers.toString());
        assertEquals("[0, 1, 2, 3, 4, 6, 7, 8, 9]", myOwnArrayListOfIntegers.toString());
    }

    @Test
    void testSort() {
        var random = new Random();
        var list = new MyOwnArrayList<>();
        for (int i = 9; i >= 0; i--) {
            list.add(i);
        }
        list.sort();
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
    }



}