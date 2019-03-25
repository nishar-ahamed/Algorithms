package com.algorithms.search.binarysearch;

public class BinarySearch {

    public int binarySearch(int a[], int x) {
        int p = 0;
        int r = a.length - 1;
        while (p <= r) {
            int q = (p + r) / 2;
            if (a[q] > x) r = q - 1;
            else if (a[q] < x) p = q + 1;
            else return q;
        }
        return -1;
    }

    public int recursiveBinarySearch(int a[], int p, int r, int x) {
        if (p > r) return -1;
        int q = (p + r) / 2;
        if (a[q] == x) return q;
        else if (a[q] > x) return recursiveBinarySearch(a, p, q - 1, x);
        else return recursiveBinarySearch(a, q + 1, r, x);
    }

    public static void main(String args[]) {
        int a[] = new int[]{1, 2, 4, 7, 8, 9, 10, 15};
        BinarySearch bs = new BinarySearch();
        //System.out.print(bs.binarySearch(a,13));
        System.out.print(bs.recursiveBinarySearch(a, 0, a.length - 1, 16));
    }
}
