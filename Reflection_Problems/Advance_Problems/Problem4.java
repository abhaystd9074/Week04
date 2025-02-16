package org.example.Reflection_Problems.Advance_Problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Step 1: Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

// Step 2: Define Dependencies
class Service {
    public void execute() {
        System.out.println("Service Executed!");
    }
}

// Step 3: Define a Class with Dependencies
class Client {
    @Inject
    private Service service; // Field to be injected

    public void performTask() {
        service.execute();
    }
}

// Step 4: Implement a Simple DI Container
class DIContainer {
    public static void injectDependencies(Object obj) {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    field.setAccessible(true); // Allow modification of private fields
                    Object dependency = field.getType().getDeclaredConstructor().newInstance(); // Create instance
                    field.set(obj, dependency); // Inject dependency
                } catch (Exception e) {
                    throw new RuntimeException("Failed to inject dependencies", e);
                }
            }
        }
    }
}

// Step 5: Use the DI Container
public class Problem4 {
    public static void main(String[] args) {
        Client client = new Client();

        // Inject dependencies dynamically
        DIContainer.injectDependencies(client);

        // Call method to check if Service was injected
        client.performTask();
    }
}
