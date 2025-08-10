package Sorting;

public class MergeSort {

    public static void merge(int[] arr, int left, int middle, int right) {
        int lowerIndexArray1 = left;
        int lowerIndexArray2 = middle + 1;
        int array1Length = middle - left + 1;
        int array2Length = right - middle ;
        int[] subArray1 = new int[array1Length];
        int[] subArray2 = new int[array2Length];

        for (int i = 0; i <= array1Length - 1; i++) {
            subArray1[i] = arr[lowerIndexArray1 + i];
        }

        for (int i = 0; i <= array2Length - 1; i++) {
            subArray2[i] = arr[lowerIndexArray2 + i];
        }
        int runningIndexArray1 = 0, runningIndexArray2 = 0, mainArrayIndex = left;
        while (runningIndexArray1 < array1Length && runningIndexArray2 < array2Length) {
            if(subArray1[runningIndexArray1] <= subArray2[runningIndexArray2]) {
                arr[mainArrayIndex] = subArray1[runningIndexArray1];
                runningIndexArray1++;
            } else {
                arr[mainArrayIndex] = subArray2[runningIndexArray2];
                runningIndexArray2++;
            }
            mainArrayIndex++;
        }

        while(runningIndexArray1 < array1Length) {
            arr[mainArrayIndex] = subArray1[runningIndexArray1];
            runningIndexArray1++;
            mainArrayIndex++;
        }

        while (runningIndexArray2 < array2Length) {
            arr[mainArrayIndex] = subArray2[runningIndexArray2];
            runningIndexArray2++;
            mainArrayIndex++;
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
