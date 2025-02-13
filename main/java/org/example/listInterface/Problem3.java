package org.example.listInterface;

import java.util.ArrayList;
import java.util.Collections;

public class Problem3 {
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
        System.out.println("orignal arraylist is "+arr);
        int rotate=2;
        Collections.reverse(arr);
        Collections.reverse(arr.subList(0,rotate));
        Collections.reverse(arr.subList(rotate,arr.size()));
        System.out.println("after rotating array by 2 steps "+arr);


    }

}
