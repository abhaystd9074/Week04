package org.example.Reflection_Problems.Intermediate_Problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime
@Target(ElementType.TYPE)             // Can be applied to classes only
@interface Author {
    String name();  // Annotation element
}

// Apply the custom annotation to a class
@Author(name = "Abhay")
class SampleClass {
    public void display() {
        System.out.println("Inside SampleClass method.");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> clazz = SampleClass.class;

            // Check if @Author annotation is present
            if (clazz.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author author = clazz.getAnnotation(Author.class);

                // Display the annotation value
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No @Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

