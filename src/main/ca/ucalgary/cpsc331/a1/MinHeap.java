package ca.ucalgary.cpsc331.a1;

public class MinHeap implements PriorityQueue {
    private int size = 0;
    private int N;
    private int[] heap;

    public MinHeap(int N) {
        this.N = N;
        this.size = 0;
        this.heap = new int[N];
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean full() {
        return size == N;
    }

    public void insert(int key) {
        if (full()) {
            throw new RuntimeException("Heap is full");
        }
        heap[size] = key;
        size++;

    }

    public int extractMin() {
        if (empty()) {
            throw new RuntimeException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        return min;

    }

    public int min() {
        if (empty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

}