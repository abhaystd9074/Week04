package org.example.JUnit_Problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Problem1Test {

    Problem1 calculator = new Problem1();

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(5, 5));
        assertEquals(-3, calculator.add(-1, -2));
    }

    @Test
    void testSubtraction() {
        assertEquals(3, calculator.subtract(5, 2));
        assertEquals(-4, calculator.subtract(-2, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, calculator.multiply(4, 5));
        assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(-3, calculator.divide(-9, 3));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
