package org.example.Annotation_Problems.IntermediateProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// Step 1: Define the Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD) // Can be applied to fields
@interface MaxLength {
    int value(); // Maximum allowed length
}

// Step 2: Apply @MaxLength to a Field in User Class
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
        System.out.println("User created successfully: " + username);
    }

    // Step 3: Validate Field Length Using Reflection
    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (value.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength + " characters!");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Test the Validation Logic
public class Problem2{
    public static void main(String[] args) {
        try {
            new User("ShortName"); // Valid
            new User("ThisIsTooLong"); // Invalid, should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
