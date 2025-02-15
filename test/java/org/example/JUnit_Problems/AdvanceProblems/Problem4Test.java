package org.example.JUnit_Problems.AdvanceProblems;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Problem4Test {

    @Test
    void testValidDateFormat() {
        assertEquals("15-08-2024", DateFormatter.formatDate("2024-08-15"), "Date should be formatted correctly.");
        assertEquals("01-01-2023", DateFormatter.formatDate("2023-01-01"), "Date should be formatted correctly.");
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15/08/2024"), "Invalid format should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2024-15-08"), "Invalid format should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("abcd-ef-gh"), "Invalid characters should throw an exception.");
    }
}
