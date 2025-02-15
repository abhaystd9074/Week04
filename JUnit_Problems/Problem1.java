package org.example.JUnit_Problems;

public class Problem1 {
    public static int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        int ans=add(5,5);
        System.out.println(ans);
    }
}
