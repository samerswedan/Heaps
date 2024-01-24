

public class MaxHeap {
  private int[] heap;
  private int size;
  private int maxSize;

  public MaxHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    this.heap = new int[maxSize + 1];
    this.heap[0] = Integer.MAX_VALUE;
  }

  private int parent(int pos) {
    return pos / 2;
  }

  private int leftChild(int pos) {
    return (2 * pos);
  }

  private int rightChild(int pos) {
    return (2 * pos) + 1;
  }

  private boolean isLeaf(int pos) {
    return pos > (size / 2) && pos <= size;
  }

  private void swap(int fpos, int spos) {
    int tmp;
    tmp = heap[fpos];
    heap[fpos] = heap[spos];
    heap[spos] = tmp;
  }

  private void maxHeapify(int pos) {
    if (isLeaf(pos))
      return;

    if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
      if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
        swap(pos, leftChild(pos));
        maxHeapify(leftChild(pos));
      } else {
        swap(pos, rightChild(pos));
        maxHeapify(rightChild(pos));
      }
    }
  }

  public void insert(int element) {
    heap[++size] = element;

    int current = size;
    while (heap[current] > heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  public boolean full() {
    return size == maxSize;
  }

  public boolean empty() {
    return size == 0;
  }

  public int extractMax() {
    int popped = heap[1];
    heap[1] = heap[size--];
    maxHeapify(1);
    return popped;
  }

  public void print() {
    for (int i = 1; i <= size / 2; i++) {
      System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
      System.out.println();
    }
  }

  public int max() {
    return heap[1];
  }

  public void heapIncreaseKey(int i, int j) {
    if (j < heap[i]) {
      throw new RuntimeException("New key is smaller than current key");
    }
    heap[i] = j;
    while (i > 0 && heap[parent(i)] < heap[i]) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

}
