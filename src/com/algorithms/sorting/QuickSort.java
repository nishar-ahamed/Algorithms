package com.algorithms.sorting;

public class QuickSort {

    public static void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            System.out.println("pivot: "+array[q]);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r);
        return i + 1;
    }

    public static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] arrayList = new int[]{33, 14, 5, 10, 7, 6, 1};
        quickSort(arrayList, 0, arrayList.length - 1);
        for (int i = 0; i < arrayList.length; i++) {
            System.out.println("" + arrayList[i]);
        }
    }
}
