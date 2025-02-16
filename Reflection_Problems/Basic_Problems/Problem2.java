package org.example.Reflection_Problems.Basic_Problems;

import java.lang.reflect.Field;
class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);
            person.displayAge();  // Output: Age: 25

            // Get the Class object
            Class<?> clazz = person.getClass();

            // Access the private field "age"
            Field ageField = clazz.getDeclaredField("age");

            // Make the field accessible
            ageField.setAccessible(true);

            // Get the current value of "age"
            int currentAge = (int) ageField.get(person);
            System.out.println("Retrieved Age: " + currentAge);

            // Modify the "age" field value
            ageField.set(person, 30);

            // Display the updated value
            person.displayAge();  // Output: Age: 30

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
