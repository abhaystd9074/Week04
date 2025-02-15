package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text containing URLs:");
        String text = sc.nextLine();

        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\S*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }

        if (links.isEmpty()) {
            System.out.println("No links found.");
        } else {
            System.out.println("Extracted Links:");
            System.out.println(String.join(", ", links));
        }

        sc.close();
    }
}
