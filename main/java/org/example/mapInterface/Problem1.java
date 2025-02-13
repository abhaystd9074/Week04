package org.example.mapInterface;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;

public class Problem1 {
    public static void main(String[] args) {
        try {
            String path = "D:\\Week04\\Day02\\src\\main\\java\\org\\example\\mapInterface\\text.txt";
            FileReader fr= new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
                HashMap<String,Integer>mp=new HashMap<>();
               s= s.toLowerCase();
               String []arr=s.split("[ ,!.]+");
               for(String it:arr){
                   mp.put(it,mp.getOrDefault(it,0)+1);
                }
                System.out.println("frequency of words in given string is:"+mp);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}
