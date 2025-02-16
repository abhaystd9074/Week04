package org.example.Annotation_Problems.Excercise_Problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

// Step 1: Define the Repeatable Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 2: Define a Container for the Repeatable Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 3: Apply @BugReport Multiple Times on a Method
class SoftwareModule {

    @BugReport(description = "Null pointer exception occurs on edge cases.")
    @BugReport(description = "Performance issue when handling large data sets.")
    public void processData() {
        System.out.println("Processing data...");
    }
}

// Step 4: Retrieve and Print All Bug Reports Using Reflection
public class Problem5 {
    public static void main(String[] args) {
        try {
            Method method = SoftwareModule.class.getMethod("processData");

            // Retrieve and print multiple annotations
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports reports = method.getAnnotation(BugReports.class);
                for (BugReport report : reports.value()) {
                    System.out.println("Bug Report: " + report.description());
                }
            }

            // Call the method to verify its behavior
            SoftwareModule module = new SoftwareModule();
            module.processData();

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
        }
    }
}
