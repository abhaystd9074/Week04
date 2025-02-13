package org.example;

import java.util.*;


class BankingSystem {
    private HashMap<Integer, Double> accounts;
    private Queue<Integer> withdrawalQueue;

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void deposit(int accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " -> Balance: " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(101, 500.0);
        bank.createAccount(102, 1500.0);
        bank.createAccount(103, 800.0);

        bank.deposit(101, 200.0);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(101);

        bank.displaySortedAccounts();
        bank.processWithdrawals();
    }
}

