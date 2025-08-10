package Sorting;

public class QuickSort {

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private static int partition(int[] inputArr, int low, int high) {
        int pivotElement = inputArr[high];
        int largerEntryIndex = low - 1; // Means there's nothing larger yet

        for (int currentIndex = low; currentIndex <= high - 1; currentIndex++) {
            if (inputArr[currentIndex] <= pivotElement) {
                largerEntryIndex++;
                swap(inputArr, largerEntryIndex, currentIndex);
            }
        }

        swap(inputArr, high, largerEntryIndex + 1);
        return largerEntryIndex + 1;

    }

    private static void quickSort(int[] inputArr, int low, int high) {
        if (low < high) {
            int elementsSortedAtIndex = partition(inputArr, low, high);
            quickSort(inputArr, low, elementsSortedAtIndex - 1);
            quickSort(inputArr, elementsSortedAtIndex + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] inputArr = new int[] { 8, 4, 1, 7, 0, 2 };
        quickSort(inputArr, 0, inputArr.length - 1);

        for (int i : inputArr) {
            System.err.println(i);
        }
    }
}
