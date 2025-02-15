package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;

public class Problem15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Social Security Number (SSN):");
        String ssn = sc.nextLine();

        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        if (matcher.matches()) {
            System.out.println( ssn + "\" is valid");
        } else {
            System.out.println(ssn + "\" is invalid");
        }

        sc.close();
    }
}
