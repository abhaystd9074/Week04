package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Instructions for creating a username: ");
        System.out.println("Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)\n" +
                "Must start with a letter\n" +
                "Must be between 5 to 15 characters long\n");

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.print("Enter a username: ");
            String username = sc.nextLine();
            Matcher matcher = pattern.matcher(username);

            if (matcher.matches()) {
                System.out.println("Valid username!");
                break;
            } else {
                System.out.println("Invalid username! Please follow the instructions.");
            }
        }

        sc.close();
    }
}
