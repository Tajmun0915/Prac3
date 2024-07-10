package org.example;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 2, 45, 11, 23, 1, 9, 4};

        System.out.print("Before Sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(arr);

        System.out.print("After Sorting: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        int size = arr.length;
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int sizeL = left.length;
        int sizeR = right.length;
        int i = 0, j = 0, k = 0;

        while (i < sizeL && j < sizeR) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < sizeL) {
            arr[k++] = left[i++];
        }

        while (j < sizeR) {
            arr[k++] = right[j++];
        }
    }
}
