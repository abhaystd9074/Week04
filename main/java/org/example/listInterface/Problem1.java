package org.example.listInterface;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem1 {
    public static void reverse1(ArrayList<Integer>arr){
        int i=0,j=arr.size()-1;
        while(i<=j){
            int temp=arr.get(i);
             arr.set(i,arr.get(j));
             arr.set(j,temp);
             i++;j--;
        }

    }
    public static void reverse2(LinkedList<Integer>list) {
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;

        }
    }
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(9);
        arr.add(8);
        arr.add(7);
        arr.add(6);
        arr.add(5);
        arr.add(4);
        arr.add(3);
        System.out.println("original arrayList is "+arr);
        reverse1(arr);
        System.out.println("after reverse arrList is "+ arr);

        LinkedList<Integer>linkList=new LinkedList<>(arr);
        System.out.println("original linkedList is "+linkList);
        reverse2(linkList);
        System.out.println("after reverse linkedList is "+ linkList);


    }


}
