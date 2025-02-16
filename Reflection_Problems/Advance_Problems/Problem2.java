package org.example.Reflection_Problems.Advance_Problems;

import java.lang.reflect.Field;

class Person2 {
    private String name;
    private int age;
    private String city;

    // Constructor
    public Person2(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}

public class Problem2 {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        // Get the class object
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Allow access to private fields
            try {
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);

                json.append("\"").append(fieldName).append("\": ");

                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        // Create an instance of Person2
        Person2 person = new Person2("Abhay", 25, "Delhi");

        // Convert to JSON-like string
        String jsonString = toJson(person);

        // Print JSON representation
        System.out.println(jsonString);
    }
}
