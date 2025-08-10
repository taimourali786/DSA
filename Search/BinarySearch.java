package Search;

public class BinarySearch {

    public static boolean searchIterative(int[] arr, int valueToSearch) {

        int left = 0, right = arr.length - 1;
        int middle = (left + right) / 2;

        int loopRunCount = 0;
        while (left < right) {
            loopRunCount++;
            if (valueToSearch < arr[middle]) {
                right = middle - 1 ;
                middle = (left + right) / 2;
            } else if (valueToSearch > arr[middle]) {
                left = middle + 1;
                middle = left + (middle + right) / 2;
            } else if (valueToSearch == arr[middle]) {
                System.out.println(loopRunCount);
                return true;
            }
        }
        System.out.println(loopRunCount);
        return false;
    }

    private static boolean searchRecursive(int[] arr, int left, int right, int valueToSearch) {
        if (left > right) {
            return false;
        }
        int middle = left + (right - left) / 2;
        if (valueToSearch < arr[middle]) {
            return searchRecursive(arr, left, middle - 1 , valueToSearch);
        } else if (valueToSearch > arr[middle]) {
            return searchRecursive(arr, middle + 1, right, valueToSearch);
        } else if (valueToSearch == arr[middle]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 3, 6, 7, 9, 11 };
        // System.out.println(searchIterative(arr, 0));
        System.out.println(searchRecursive(arr, 0, arr.length - 1, 1));
    }
}