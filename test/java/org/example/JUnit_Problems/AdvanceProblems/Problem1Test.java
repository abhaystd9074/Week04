package org.example.JUnit_Problems.AdvanceProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class Problem1Test {

    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(100.0); // Initialize with $100
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    void testWithdraw() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be updated after withdrawal");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-20.0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10.0);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
}
