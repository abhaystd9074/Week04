package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem5 {
    public static void main(String[] args) {
        String path="D:\\Week04\\Day04\\src\\main\\java\\org\\example\\data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("First line: " + br.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}

