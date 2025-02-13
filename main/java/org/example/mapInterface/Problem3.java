package org.example.mapInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem3 {
    public static void main(String[] args) {
        HashMap<Character,Integer> mp=new HashMap<>();
        mp.put('A',10);
        mp.put('B',30);
        mp.put('C',40);
        mp.put('D',9);
        mp.put('E',15);
        int maxi=0; char c='\0';
        for(Character it:mp.keySet()){
            if(mp.get(it) > maxi){
                maxi=mp.get(it);
                 c=it;
            }

        }
        System.out.println("key with maximum value is: "+c+" with value "+mp.get(c));

    }
}
