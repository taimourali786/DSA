package Heap;

import java.util.*;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Insert new element
    public void insert(int value) {
        heap.add(value); // add at the end
        heapifyUp(heap.size() - 1); // fix heap property
    }

    // Maintain heap property (bubble up)
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) < heap.get(parentIndex)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }

    }

    // Extract max (root)
    public int extractMax() {
        if (heap.isEmpty())
            throw new NoSuchElementException("Heap is empty");

        int max = heap.get(0);

        // Move last element to root
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

    // Maintain heap property (bubble down)
    private void heapifyDown(int index) {
        int size = heap.size();

        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            String s = "aksdjasklj";
    
            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int[] nums = { 10, 20, 5, 30, 25 };

        for (int num : nums) {
            maxHeap.insert(num);
            maxHeap.printHeap();
        }

        System.out.println("Extracted Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}
