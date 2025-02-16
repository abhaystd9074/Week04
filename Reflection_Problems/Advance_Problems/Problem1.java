package org.example.Reflection_Problems.Advance_Problems;

import java.lang.reflect.Field;
import java.util.Map;

class Person {
    private String name;
    private int age;
    private String city;

    // Default constructor
    public Person() {}

    // Method to display object details
    public void display() {
        System.out.println("Person{name='" + name + "', age=" + age + ", city='" + city + "'}");
    }
}

public class Problem1 {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate over the map and set field values
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    // Get the field from the class
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow modifying private fields

                    // Set the field value
                    field.set(obj, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Error creating object: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        // Create a Map with field values
        Map<String, Object> personData = Map.of(
                "name", "Abhay",
                "age", 25,
                "city", "Delhi"
        );

        // Convert the Map to a Person object
        Person person = toObject(Person.class, personData);

        // Display the populated object
        person.display();
    }
}
