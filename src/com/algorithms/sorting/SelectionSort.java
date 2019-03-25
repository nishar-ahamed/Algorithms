package com.algorithms.sorting;

public class SelectionSort {

    public static void main(String args[]) {
        int[] arrayList = new int[]{33, 14, 5, 10, 7, 6, 1};
        int[] sortedArray = selectionSort(arrayList);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println("" + sortedArray[i]);
        }
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
