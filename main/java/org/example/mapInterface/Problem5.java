package org.example.mapInterface;

import java.util.ArrayList;
import java.util.HashMap;

class Employee{
    String name;
    String depart;
    public Employee(String name,String depart){
        this.name=name;
        this.depart=depart;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        ArrayList<Employee>emp=new ArrayList<>();
        emp.add(new Employee("Abhay","HR"));
        emp.add(new Employee("Tikesh","HR"));
        emp.add(new Employee("Nishank","IT"));
        emp.add(new Employee("Aaman","IT"));
        emp.add(new Employee("Vikash","TR"));
        emp.add(new Employee("Sonu","MR"));


        HashMap<String, ArrayList<String>> mp=new HashMap<>();
        for(Employee e:emp){
           if(!mp.containsKey(e.depart)){
               ArrayList<String>arr=new ArrayList<>();
               arr.add(e.name);
                       mp.put(e.depart,arr);
           }
           else{
               mp.get(e.depart).add(e.name);
           }
        }
        System.out.println(mp);


    }
}
