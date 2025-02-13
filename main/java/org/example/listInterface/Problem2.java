package org.example.listInterface;

import java.util.ArrayList;
import java.util.HashMap;


public class Problem2 {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("apple");
        arr.add("banana");
        arr.add("orange");
        arr.add("apple");
        arr.add("mango");
        arr.add("banana");
        arr.add("banana");
        System.out.println("arrayList is "+arr);
        HashMap<String,Integer>mp=new HashMap<>();
        for(String it:arr){
            mp.put(it, mp.getOrDefault(it,0)+1);
        }
        System.out.println("frequency of the elements is "+mp);




    }
}
