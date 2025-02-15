package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("License plate format: Two uppercase letters followed by four digits (e.g., AB1234)\n");

        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.print("Enter a license plate number: ");
            String plateNumber = sc.nextLine();
            Matcher matcher = pattern.matcher(plateNumber);

            if (matcher.matches()) {
                System.out.println("Valid license plate number!");
                break;
            } else {
                System.out.println("Invalid license plate number! Please follow the format (AB1234).");
            }
        }

        sc.close();
    }
}
