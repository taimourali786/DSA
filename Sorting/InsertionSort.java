package Sorting;


public class InsertionSort {
/*                  Best    Worsrt  Average
 * Time Complexity: O(n)    O(n2)   O(n2)
 * Space Complexity:        O(1)
 * Stable: Yes
 */
    public static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j > 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j] = key;
        }
    }

    public static void main(String[] args) {
        int[] inputArr = new int[] { 9, 3, 2, 5, 6, 9 };
        insertionSort(inputArr);
        for (int i : inputArr) {
            System.out.println(i); 
        }
    }
}
