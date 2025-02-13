package org.example.listInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Problem4 {
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        System.out.println("orignal array is "+arr);
        HashMap<Integer,Integer>mp=new HashMap<>();
        Iterator<Integer> it = arr.iterator();

        while (it.hasNext()) {
            int temp = it.next();
            if (mp.containsKey(temp)) {
                it.remove(); // Safe removal using iterator
            } else {
                mp.put(temp, 1);
            }
        }

        System.out.println("after removing duplicate elements arrayList is "+arr);

    }
}
