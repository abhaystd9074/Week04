package org.example.Annotation_Problems.Excercise_Problems;

import java.util.ArrayList;

// Step 1: Define a Class with a Method That Uses Raw Types
class WarningExample {

    @SuppressWarnings("unchecked") // Suppresses unchecked warning
    public void addElements() {
        ArrayList list = new ArrayList(); // Raw type (no generics used)
        list.add("Hello");
        list.add(123); // Adding different types without warnings

        System.out.println("List contents: " + list);
    }
}

// Step 2: Test the Method
public class Problem3 {
    public static void main(String[] args) {
        WarningExample example = new WarningExample();
        example.addElements();
    }
}
