package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memory = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            int remaining = target - nums[i];
            if (memory.containsKey(remaining)) {
                return new int[] { i, memory.get(remaining) };
            } else {
                memory.put(nums[i], i);
            }
            i++;
        }
        return new int[] {};
    }

    public double findMaxAverage(int[] nums, int k) {
        // int[] slidingWindow = new int[k];
        double maxSum = 0;
        int sum = 0;
        for (int i = 0; i <= k - 1; i++) {
            sum += nums[i];
        }
        int i = k;
        while (i < nums.length - 1) {
            maxSum = Math.max(sum, maxSum);
            sum += nums[k];
            sum -= nums[i - k];
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 4, 8, 3, 6, 2, 1 };
        int[] output = twoSum(input, 15);
        for (int i : output) {
            System.out.println(i);
        }
    }
}
