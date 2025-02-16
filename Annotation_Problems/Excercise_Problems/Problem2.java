package org.example.Annotation_Problems.Excercise_Problems;

// Step 1: Define LegacyAPI Class
class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: oldFeature() is deprecated. Use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Step 2: Test the Methods
public class Problem2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Calling deprecated method (should show a warning)
        api.oldFeature();

        // Calling new method
        api.newFeature();
    }
}
