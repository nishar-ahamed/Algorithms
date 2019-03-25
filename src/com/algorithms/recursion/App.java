package com.algorithms.recursion;

public class App {
    public static void main(String args[]) {
        System.out.print(recursiveLinearSearch(new int[]{1,2,4,7,8,9,10,15},0,10));
    }

    public static int recursiveLinearSearch(int a[], int i, int x) {
        int n = a.length - 1;
        if (i > n) return -1;
        else if (a[i] == x) return i;
        else return recursiveLinearSearch(a, i + 1, x);
    }
}
