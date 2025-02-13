package org.example.setInterfce;

import java.util.Collections;
import java.util.HashSet;


public class Problem1 {
    public static void main(String[] args) {
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        Collections.addAll(set1,1,2,3);
        Collections.addAll(set2,3,2,1);


        System.out.println("two sets are equal? "+set1.equals(set2));



    }
}
