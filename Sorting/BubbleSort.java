package Sorting;
import java.util.*;

public class BubbleSort {
/*                  Best    Worsrt  Average
 * Time Complexity: O(n)    O(n2)   O(n2)
 * Space Complexity:        O(1)
 * Stable: Yes
 */
    public static void bubbleSort(List<Integer> arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    Integer temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> inputArr = new ArrayList<>(List.of(9,3, 2, 5, 6, 9));
        bubbleSort(inputArr);
        for (int i : inputArr) {
            System.out.println(i); 
        }
    }
}
