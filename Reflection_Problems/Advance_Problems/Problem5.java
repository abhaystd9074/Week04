package org.example.Reflection_Problems.Advance_Problems;

import java.lang.reflect.Method;

// Step 1: Define a Sample Class with Methods
class Task {
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(2000); // Simulate a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 2: Implement Method Execution Timer Using Reflection
public class Problem5 {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            // Get the method dynamically
            Method method = obj.getClass().getMethod(methodName);

            // Measure execution time
            long startTime = System.nanoTime();
            method.invoke(obj); // Invoke method dynamically
            long endTime = System.nanoTime();

            // Print execution time
            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Task task = new Task();

        // Measure execution time of methods
        measureExecutionTime(task, "fastMethod");
        measureExecutionTime(task, "slowMethod");
    }
}
