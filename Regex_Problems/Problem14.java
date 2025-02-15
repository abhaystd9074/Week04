package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;
import java.util.HashSet;

public class Problem14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        HashSet<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        if (repeatingWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating Words:");
            System.out.println(String.join(", ", repeatingWords));
        }

        sc.close();
    }
}
