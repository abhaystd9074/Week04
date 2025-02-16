package org.example.Reflection_Problems.Basic_Problems;

import java.lang.reflect.*;

public class Problem1 {
    public static void main(String[] args) {
        String className = "org.example.Reflection_Problems.Basic_Problems.Problem1";

        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Display class name
            System.out.println("Class Name: " + clazz.getSimpleName());

            // Display fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("No fields found.");
            } else {
                for (Field field : fields) {
                    System.out.println(field.getName() + " : " + field.getType());
                }
            }

            // Display methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("No methods found.");
            } else {
                for (Method method : methods) {
                    System.out.print(method.getName() + "(");
                    // Display parameter types
                    Class<?>[] paramTypes = method.getParameterTypes();
                    for (int i = 0; i < paramTypes.length; i++) {
                        System.out.print(paramTypes[i].getSimpleName());
                        if (i < paramTypes.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println(") : " + method.getReturnType().getSimpleName());
                }
            }

            // Display constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length == 0) {
                System.out.println("No constructors found.");
            } else {
                for (Constructor<?> constructor : constructors) {
                    System.out.print(clazz.getSimpleName() + "(");
                    // Display parameter types
                    Class<?>[] paramTypes = constructor.getParameterTypes();
                    for (int i = 0; i < paramTypes.length; i++) {
                        System.out.print(paramTypes[i].getSimpleName());
                        if (i < paramTypes.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println(")");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
