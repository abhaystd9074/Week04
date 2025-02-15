package org.example.JUnit_Problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ProblemTest3 {

    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(testList, 10);
        assertTrue(testList.contains(10));

        listManager.addElement(testList, 20);
        assertTrue(testList.contains(20));
    }

    @Test
    void testRemoveElement() {
        testList.add(10);
        testList.add(20);

        assertTrue(listManager.removeElement(testList, 10));  // Element exists
        assertFalse(testList.contains(10));  // Ensure it's removed

        assertFalse(listManager.removeElement(testList, 30)); // Element doesn't exist
    }

    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(testList));

        testList.add(10);
        testList.add(20);
        assertEquals(2, listManager.getSize(testList));

        testList.remove(Integer.valueOf(10));
        assertEquals(1, listManager.getSize(testList));
    }
}
