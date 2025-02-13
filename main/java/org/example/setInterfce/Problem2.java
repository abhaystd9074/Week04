package org.example.setInterfce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem2 {
    public static void main(String[] args) {
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        Collections.addAll(set1,1,2,3);
        Collections.addAll(set2,3,4,5);

        HashSet<Integer>unionOfArray=new HashSet<>();
        HashSet<Integer>intersectionOfArray=new HashSet<>();
        for(int it:set1){
            unionOfArray.add(it);
        }
        for(int it:set2){
            unionOfArray.add(it);
        }
        for(int it:set1){
            if(set2.contains(it)){
                intersectionOfArray.add(it);
            }
        }
        System.out.println("first set is: "+set1);
        System.out.println("first set is: "+set2);
        System.out.println("union of two set is: "+unionOfArray);
        System.out.println("insertion of two sets is: "+intersectionOfArray);

    }
}
