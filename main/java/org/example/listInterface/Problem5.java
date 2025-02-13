package org.example.listInterface;

import java.util.Collections;
import java.util.LinkedList;

public class Problem5 {
    public static void main(String[] args) {

        LinkedList<Character>list=new LinkedList<>();
        Collections.addAll(list,'a','b','c','d','e');
        Collections.reverse(list);
         int index=2;
        System.out.println("element from second last is "+list.get(index-1));

    }
}
