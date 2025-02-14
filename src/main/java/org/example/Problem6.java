package org.example;

import java.util.Scanner;

public class Problem6 {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            System.out.print("Enter rate: ");
            double rate = sc.nextDouble();
            System.out.print("Enter years: ");
            int years = sc.nextInt();

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}

