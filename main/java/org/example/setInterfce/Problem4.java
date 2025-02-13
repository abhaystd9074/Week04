package org.example.setInterfce;

import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        HashSet<Integer>set=new LinkedHashSet<>();
        Collections.addAll(set,5,3,7,9,1);
        ArrayList<Integer>ans=new ArrayList<>();

        for(int i:set){
            ans.add(i);
        }
        Collections.sort(ans);
        System.out.println("original hash set is: "+set);
        System.out.println("sorted list is: "+ans);



    }
}
