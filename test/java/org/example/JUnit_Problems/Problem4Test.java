package org.example.JUnit_Problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Problem4Test {

    private final MathOperations mathOperations = new MathOperations();

    @Test
    void testDivideByNonZero() {
        assertEquals(5, mathOperations.divide(10, 2));
        assertEquals(-3, mathOperations.divide(-9, 3));
    }

    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            mathOperations.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
