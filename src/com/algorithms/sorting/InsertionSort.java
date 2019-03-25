package com.algorithms.sorting;

public class InsertionSort {

    public static void main(String args[]) {
        int[] arrayList = new int[]{33, 14, 5, 10, 7, 6, 1};
        int[] sortedArray = insertionSort(arrayList);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println("" + sortedArray[i]);
        }
    }

    public static int[] insertionSort(int[] arrayList) {
        for (int i = 1; i < arrayList.length; i++) {
            int element = arrayList[i];
            int j = i - 1;
            while (j >= 0 && arrayList[j] > element) {
                arrayList[j + 1] = arrayList[j];
                j--;
            }
            arrayList[j + 1] = element;
        }
        return arrayList;
    }
}
