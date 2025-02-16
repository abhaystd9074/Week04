package org.example.Reflection_Problems.Basic_Problems;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    // Default constructor
    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }

    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class Problem4 {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> clazz = Class.forName("org.example.Reflection_Problems.Basic_Problems.Student");

            // Create an instance using the default constructor
            Object student1 = clazz.getDeclaredConstructor().newInstance();
            ((Student) student1).displayInfo();  // Output: Student Name: Default Name, Age: 18

            // Create an instance using the parameterized constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            Object student2 = constructor.newInstance("Abhay", 22);
            ((Student) student2).displayInfo();  // Output: Student Name: Abhay, Age: 22

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
