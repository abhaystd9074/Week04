package org.example.Annotation_Problems.beginnerProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

// Step 2: Use the Annotation in a Class
class TaskProcessor {

    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantTask() {
        System.out.println("Executing important task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

// Step 3: Retrieve and Print Annotated Methods Using Reflection
public class Problem1 {
    public static void main(String[] args) {
        Class<TaskProcessor> obj = TaskProcessor.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }

        // Execute the tasks to verify behavior
        TaskProcessor processor = new TaskProcessor();
        processor.criticalTask();
        processor.importantTask();
        processor.normalTask();
    }
}
