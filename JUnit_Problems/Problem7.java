package org.example.JUnit_Problems;

public class Problem7 {
    public void longRunningTask() {
        try {
            Thread.sleep(3000); // Simulates a long-running task (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
