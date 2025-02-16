package org.example.Annotation_Problems.beginnerProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM"; // Default priority is MEDIUM
}

// Step 2: Use the Annotation in a Class
class ProjectModule {

    @Todo(task = "Implement login authentication", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Add dark mode support", assignedTo = "Charlie", priority = "LOW")
    public void addDarkMode() {
        System.out.println("Dark mode feature pending...");
    }
}

// Step 3: Retrieve and Print All Pending Tasks Using Reflection
public class Problem2 {
    public static void main(String[] args) {
        Class<ProjectModule> obj = ProjectModule.class;

        System.out.println("Pending Tasks:");
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println("Method Name: " + method.getName());
                System.out.println("------------------------------");
            }
        }

        // Call methods to verify behavior
        ProjectModule module = new ProjectModule();
        module.loginFeature();
        module.optimizeDatabase();
        module.addDarkMode();
    }
}
