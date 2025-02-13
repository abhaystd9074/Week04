package org.example.setInterfce;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Problem5 {
    public static void main(String[] args) {
        HashSet<Integer>child=new LinkedHashSet<>();
        Collections.addAll(child,2,3);
        HashSet<Integer>parent=new LinkedHashSet<>();
        Collections.addAll(parent,1,2,3,4);
        System.out.println("is set1: "+ child +" subset of: "+parent+" ?: "+parent.containsAll(child));
    }
}
