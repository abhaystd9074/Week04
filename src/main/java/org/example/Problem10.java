package org.example;

import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Insufficient balance!");
    }
}

public class Problem10 {
    private double balance;

    public Problem10(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Problem10 account = new Problem10(1000); // Example account with 1000 balance

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
