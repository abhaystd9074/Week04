package org.example.Annotation_Problems.Excercise_Problems;

// Step 1: Define Parent Class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Step 2: Define Child Class That Overrides makeSound()
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

// Step 3: Test the Method
public class Problem1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound(); // Calls the overridden method in Dog
    }
}
