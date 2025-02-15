package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text containing email addresses:");
        String text = sc.nextLine();

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }

        if (emails.isEmpty()) {
            System.out.println("No email addresses found.");
        } else {
            System.out.println("Extracted Email Addresses:");
            for (String email : emails) {
                System.out.println(email);
            }
        }

        sc.close();
    }
}
