package org.example.Regex_Problems;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text containing dates in dd/mm/yyyy format:");
        String text = sc.nextLine();

        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> dates = new ArrayList<>();
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        if (dates.isEmpty()) {
            System.out.println("No valid dates found.");
        } else {
            System.out.println("Extracted Dates:");
            System.out.println(String.join(", ", dates));
        }

        sc.close();
    }
}
