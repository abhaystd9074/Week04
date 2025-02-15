package org.example.JUnit_Problems;

import java.util.List;

public class Problem3 {

    // Adds an element to the list
    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    // Removes an element from the list
    public boolean removeElement(List<Integer> list, int element) {
        if (list != null) {
            return list.remove(Integer.valueOf(element));
        }
        return false;
    }

    // Returns the size of the list
    public int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}
