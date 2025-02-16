package org.example.Reflection_Problems.Intermediate_Problems;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get user input for method name
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Get user input for numbers
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Get the Class object
            Class<?> clazz = mathOperations.getClass();

            // Get the method based on user input
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOperations, num1, num2);

            // Display the result
            System.out.println("Result: " + result);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: Invalid method name or parameters.");
        }
    }
}
