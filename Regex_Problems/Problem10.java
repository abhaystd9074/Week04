package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an IP address:");
        String ip = sc.nextLine();

        String regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            System.out.println("Valid IPv4 address!");
        } else {
            System.out.println("Invalid IPv4 address!");
        }

        sc.close();
    }
}
