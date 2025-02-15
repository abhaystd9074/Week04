package org.example.JUnit_Problems.AdvanceProblems;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("Abhay", "abhay@example.com", "Password1"), "Valid registration should not throw an exception.");
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "test@example.com", "Password1"), "Empty username should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("ab", "test@example.com", "Password1"), "Short username should throw an exception.");
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "invalid-email", "Password1"), "Invalid email should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "user@.com", "Password1"), "Invalid email should throw an exception.");
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "test@example.com", "short"), "Short password should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "test@example.com", "nouppercase1"), "Password without uppercase should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "test@example.com", "NoNumber"), "Password without a number should throw an exception.");
    }
}

