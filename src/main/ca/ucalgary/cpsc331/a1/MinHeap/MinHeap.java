package ca.ucalgary.cpsc331.a1.MinHeap;

import ca.ucalgary.cpsc331.a1.PriorityQueue;

public class MinHeap implements PriorityQueue {

  public int numElements = 0;
  public int N;

  @Override
  public boolean empty() {
    return numElements == 0;

  }

  @Override
  public boolean full() {
    return numElements == N;
  }

  @Override
  public void insert(int key) {
    if (full()) {
      throw new RuntimeException("Heap is full");
    }

    numElements++;

  }

  @Override
  public int extractMin() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'extractMin'");
  }

  @Override
  public int min() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'min'");
  }

}
