package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> capitalizedWords = new ArrayList<>();
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        if (capitalizedWords.isEmpty()) {
            System.out.println("No capitalized words found.");
        } else {
            System.out.println("Extracted Capitalized Words:");
            System.out.println(String.join(", ", capitalizedWords));
        }

        sc.close();
    }
}
