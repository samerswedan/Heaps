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
        heapifyUp(size - 1);
    }

    public int extractMin() {
        if (empty()) {
            throw new RuntimeException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public int min() {
        if (empty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}