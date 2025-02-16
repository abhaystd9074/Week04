package org.example.Reflection_Problems.Basic_Problems;

import java.lang.reflect.Method;
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the Class object
            Class<?> clazz = calculator.getClass();

            // Access the private method "multiply"
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);

            // Make the method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the method with arguments
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            // Display the result
            System.out.println("Multiplication Result: " + result); // Output: 20

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
