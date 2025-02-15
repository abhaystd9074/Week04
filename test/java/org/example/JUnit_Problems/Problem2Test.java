package org.example.JUnit_Problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Problem2Test {

    StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleH", stringUtils.reverse("Hello"));
        assertEquals("12345", stringUtils.reverse("54321"));
        assertNull(stringUtils.reverse(null));  // Checking for null input
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("Racecar"));
        assertFalse(stringUtils.isPalindrome("Hello"));
        assertFalse(stringUtils.isPalindrome(null)); // Checking null input
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("java"));
        assertNull(stringUtils.toUpperCase(null));  // Checking null input
    }
}
