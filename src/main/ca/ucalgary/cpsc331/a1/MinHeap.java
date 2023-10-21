// Samer Swedan 
//30098990 
//samer.swedan@ucalgary.ca
// CPSC 331 Assignment 1 4)

package main.ca.ucalgary.cpsc331.a1;

public class MinHeap implements PriorityQueue {

    private int size; // The current number of elements in the heap
    private int N; // The maximum number of elements in the heap
    private int[] heap; // The array used to store the heap

    /**
     * Constructs a new MinHeap object with the specified capacity.
     *
     * @param N the maximum number of elements that the heap can hold
     */
    public MinHeap(int N) {
        this.N = N;
        this.size = 0;
        this.heap = new int[N];
    }

    /**
     * Returns true if the heap is empty
     *
     * @return true if the heap is empty
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Returns true if the heap is full
     *
     * @return true if the heap is full
     */
    public boolean full() {
        return size == N;
    }

    /**
     * Inserts a new element into the heap.
     * Based on the psuedocode from the lecture slides.
     * 
     * @param key the element to insert
     */
    public void insert(int key) {

        // If the heap is full throw an exception
        if (full()) {
            throw new RuntimeException("Heap is full");
        }

        heap[size] = Integer.MAX_VALUE;
        heapDecreaseKey(size, key);
        size++;
    }

    /**
     * Decreases the key of the element at the specified index.
     * Based on the psuedocode from the lecture slides.
     * 
     * @param i   the index of the element to decrease the key of
     * @param key the new key
     */
    public void heapDecreaseKey(int i, int key) {

        if (key > heap[i]) {
            throw new RuntimeException("New key is larger than current key");
        }
        heap[i] = key;
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Extracts the minimum element from the heap.
     * Based on the psuedocode from the lecture slides.
     * 
     * @return the minimum element in the heap
     */
    public int extractMin() {

        // If the heap is empty throw an exception
        if (empty()) {
            throw new RuntimeException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (size > 0) {
            minHeapify(0);
        }

        return min;

    }

    /**
     * Returns the minimum element in the heap.
     * Based on the psuedocode from the lecture slides.
     * 
     * @return the minimum element in the heap
     */
    public int min() {

        // If the heap is empty throw an exception
        if (empty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    /**
     * Returns the size of the heap.
     * Based on the psuedocode from the textbook.
     * 
     * @return the size of the heap
     */
    private void minHeapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if (l < size && heap[l] < heap[i]) {
            smallest = l;
        }
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    /**
     * Swaps two elements
     * 
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Helper functions to find the parent and children of an element:
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Returns a string representation of the heap as described
     * in the assignment specification.
     * 
     * @return a string representation of the min-heap
     */
    @Override
    public String toString() {

        // initialize a string builder
        StringBuilder sb = new StringBuilder();

        // append the size of the heap to the string
        sb.append("size = ").append(size).append("\n");

        // calculate the height of the heap
        int height = (int) Math.ceil(Math.log(size + 1) / Math.log(2));
        int index = 0;

        // For each level in the heap
        for (int i = 0; i < height; i++) {
            int elementsInRow = (int) Math.pow(2, i);
            for (int j = 0; j < elementsInRow && index < size; j++) {
                sb.append(heap[index++]);
                if (j < elementsInRow - 1 && index < size) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
