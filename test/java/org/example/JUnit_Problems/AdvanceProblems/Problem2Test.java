package org.example.JUnit_Problems.AdvanceProblems;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("StrongPass1"), "Valid password should pass");
        assertTrue(PasswordValidator.isValid("HelloWorld9"), "Valid password should pass");
        assertTrue(PasswordValidator.isValid("A1b2c3d4"), "Valid password should pass");
    }

    @Test
    void testTooShortPassword() {
        assertFalse(PasswordValidator.isValid("Ab1"), "Password too short should fail");
        assertFalse(PasswordValidator.isValid("A2b3"), "Password too short should fail");
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("strongpass1"), "Missing uppercase letter should fail");
        assertFalse(PasswordValidator.isValid("password9"), "Missing uppercase letter should fail");
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("StrongPass"), "Missing digit should fail");
        assertFalse(PasswordValidator.isValid("HelloWorld"), "Missing digit should fail");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null), "Null password should fail");
    }
}

