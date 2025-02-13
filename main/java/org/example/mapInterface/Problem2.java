package org.example.mapInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem2 {
    public static void main(String[] args) {
        HashMap<Character,Integer>mp=new HashMap<>();
        mp.put('A',1);
        mp.put('B',2);
        mp.put('C',1);
        mp.put('D',2);
        mp.put('E',3);
        HashMap<Integer, ArrayList<Character>>mp2=new HashMap<>();
        for(Character it:mp.keySet()){
            Character key=it;
            Integer val=mp.get(it);
           if(!mp2.containsKey(val)){
              ArrayList<Character>arr=new ArrayList<>();
              arr.add(key);
              mp2.put(val,arr);
           }
           else{
              mp2.get(val).add(key);
           }

        }
        System.out.println("initial array is: "+mp);
        System.out.println("inverted map is: "+mp2);


    }
}
