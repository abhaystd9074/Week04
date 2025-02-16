package org.example.Annotation_Problems.Excercise_Problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD) // Can only be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Use Annotation in TaskManager Class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Completing high-priority task...");
    }
}

// Step 3: Retrieve Annotation Details Using Reflection
public class Problem4 {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            // Call the method to see its output
            TaskManager manager = new TaskManager();
            manager.completeTask();
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
        }
    }
}
