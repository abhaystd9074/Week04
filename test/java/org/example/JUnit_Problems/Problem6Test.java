package org.example.JUnit_Problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Problem6Test {

    private final EvenNumberChecker checker = new EvenNumberChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(checker.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(checker.isEven(number), number + " should be odd");
    }
}
