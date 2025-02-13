package org.example.setInterfce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem3 {
    public static void main(String[] args) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        Collections.addAll(set1,1,2,3);
        Collections.addAll(set2,3,4,5);
        ArrayList<Integer>ans=new ArrayList<>();
        for(int it:set1){
            if(!set2.contains(it)){
                ans.add(it);
            }
        }
        for(int it:set2){
            if(!set1.contains(it)){
                ans.add(it);
            }
        }
        System.out.println("symmetric difference is: "+ans);
    }
}
