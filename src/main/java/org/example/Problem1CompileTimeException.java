package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem1CompileTimeException {
    public static void main(String[] args) {
        try {
            String path = "D:\\Week04\\Day04\\src\\main\\java\\org\\example\\data.txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("file is not present!");
            System.out.println("Content present is");
            String s;
            while((s=br.readLine())!=null){
                System.out.println(s);
            }
        }
        catch (IOException e){
            System.out.println("File not Found");
        }
    }
}
