package org.example.Annotation_Problems.AdvanceProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD) // Can be applied to fields
@interface JsonField {
    String name(); // Custom JSON key name
}

// Step 2: Define the User Class with @JsonField Annotation
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // This field won't be included in JSON

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

// Step 3: Serialize Object to JSON String
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonElements = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true); // Allow access to private fields
                    String jsonKey = field.getAnnotation(JsonField.class).name();
                    Object value = field.get(obj);
                    jsonElements.put(jsonKey, value.toString());
                }
            }
            return jsonElements.toString().replace("=", ": "); // Convert map to JSON format
        } catch (Exception e) {
            throw new RuntimeException("Error during JSON serialization", e);
        }
    }
}

// Step 4: Test Serialization
public class Problem2 {
    public static void main(String[] args) {
        User user = new User("Abhay", 25, "secret123");
        String jsonOutput = JsonSerializer.toJson(user);
        System.out.println(jsonOutput);
    }
}
