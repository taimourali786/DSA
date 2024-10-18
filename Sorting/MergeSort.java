package Sorting;

public class MergeSort {

    public static void merge(int[] arr, int left, int middle, int right) {
        int l1 = middle - left + 1;
        int l2 = right - middle;

        int[] L = new int[l1];
        int[] R = new int[l2];

        for (int i = 0; i < l1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < l2; j++) {
            R[j] = arr[middle + 1 + j];
        }
        int p1 = 0, p2 = 0, k = left;
        while (p1 < l1 && p2 < l2) {
            if (L[p1] <= R[p2]) {
                arr[k] = L[p1];
                p1++;
            } else {
                arr[k] = R[p2];
                p2++;
            }
            k++;
        }
        while (p1 < l1) {
            arr[k] = L[p1];
            k++;
            p1++;
        }
        while (p2 < l2) {
            arr[k] = R[p2];
            k++;
            p2++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print("->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] inputArr = { 6, 5, 12, 10, 9, 1 };
        mergeSort(inputArr, 0, inputArr.length - 1);
        for (int i : inputArr) {
            System.out.print(i + " ");
        }
    }
}
