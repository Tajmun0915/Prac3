package org.example;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full, cannot insert.");
        }

        heap[size] = value;
        size++;

        int index = size - 1;
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int deleteMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty, cannot delete.");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return min;
    }

    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println("Min-Heap:");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(5);

        System.out.println("Heap after insertions:");
        minHeap.printHeap();

        int min = minHeap.deleteMin();
        System.out.println("\nMin element deleted: " + min);

        System.out.println("\nHeap after deletion:");
        minHeap.printHeap();
    }
}
