package Heap;

import java.util.*;

public class Heapify {

    private List<Integer> elements;

    public Heapify(List<Integer> list) {
        this.elements = list;
    }

    public void heapify(int i) {
        int largestElementIndex = i;
        int leftChildIndex = (2 * i) + 1;
        int rightChildIndex = (2 * i) + 2;
        int size = elements.size();
        if (leftChildIndex < size && elements.get(leftChildIndex) > elements.get(largestElementIndex)) {
            largestElementIndex = leftChildIndex;
        }
        if (rightChildIndex < size && elements.get(rightChildIndex) > elements.get(largestElementIndex)) {
            largestElementIndex = rightChildIndex;
        }
        int temp = elements.get(i);
        elements.set(i, largestElementIndex);
        elements.set(largestElementIndex, temp);
        heapify(largestElementIndex);
    }

    public void insertElement(int newElement) {
        elements.add(newElement);
        for (int i = ((int) Math.floor(elements.size() / 2) - 1); i >= 0; i--) {
            heapify(i);
        }
    }

}
