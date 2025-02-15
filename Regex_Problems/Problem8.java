package org.example.Regex_Problems;
import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with multiple spaces:");
        String text = sc.nextLine();

        String modifiedText = text.replaceAll("\\s+", " ");

        System.out.println("Modified Text:");
        System.out.println(modifiedText);

        sc.close();
    }
}
