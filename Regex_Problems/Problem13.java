package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Problem13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence containing currency values:");
        String text = sc.nextLine();

        // Regex to match currency values (with or without $)
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        if (currencyValues.isEmpty()) {
            System.out.println("No currency values found.");
        } else {
            System.out.println("Extracted Currency Values:");
            System.out.println(String.join(", ", currencyValues));
        }

        sc.close();
    }
}
