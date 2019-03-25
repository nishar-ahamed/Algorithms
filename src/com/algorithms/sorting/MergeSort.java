package com.algorithms.sorting;

public class MergeSort {

    public static void mergeSort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
        int leftSlot = start;
        int rightSlot = mid + 1;

        int k = 0;
        while (leftSlot <= mid && rightSlot <= end) {
            if (array[leftSlot] < array[rightSlot]) {
                tempArray[k] = array[leftSlot];
                leftSlot++;
            } else {
                tempArray[k] = array[rightSlot];
                rightSlot++;
            }
            k++;
        }
        //System.out.println("k: "+k);
        if (leftSlot <= mid) {
            while (leftSlot <= mid) {
                tempArray[k] = array[leftSlot];
                leftSlot++;
                k++;
            }
        } else if (rightSlot <= end) {
            while (rightSlot <= end) {
                tempArray[k] = array[rightSlot];
                rightSlot++;
                k++;
            }
        }

        for (int i = 0; i < tempArray.length; i++) {
            array[start + i] = tempArray[i];
        }

    }

    public static void main(String[] args) {
        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
        mergeSort(inputArray, 0, inputArray.length - 1);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("" + inputArray[i]);
        }
    }
}
