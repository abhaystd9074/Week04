package org.example.Regex_Problems;
import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        // List of bad words to censor
        String[] badWords = {"damn", "stupid"};

        // Replace each bad word with ****
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }

        System.out.println("Censored Sentence:");
        System.out.println(text);

        sc.close();
    }
}
