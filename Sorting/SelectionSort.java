package Sorting;

import java.util.*;

public class SelectionSort {
/*                  Best    Worsrt  Average
 * Time Complexity: O(n2)    O(n2)   O(n2)
 * Space Complexity:        O(1)
 * Stable: No
 */
    public static void selectionSort(List<Integer> arr) {
        int pivot = 0;
        int len = arr.size();
        while (pivot < len - 2) {
            for (int i = pivot; i < len - 1; i++) {
                if (arr.get(i) < arr.get(pivot)) {
                    int temp = arr.get(pivot);
                    arr.set(pivot, arr.get(i));
                    arr.set(i, temp);
                }
            }
            pivot++;
        }
    }

    public static void main(String[] args) {
        List<Integer> inputArr = new ArrayList<>(List.of(9, 3, 2, 5, 6, 9));
        selectionSort(inputArr);
        for (int i : inputArr) {
            System.out.println(i); 
        }
    }

}
