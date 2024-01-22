package main.ca.ucalgary.cpsc331.a1;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaxHeapTest {

  @Test
  public void testInsert() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    heap.insert(5);
    heap.insert(4);
    assertEquals(5, heap.extractMax());
    assertEquals(4, heap.extractMax());
    assertEquals(3, heap.extractMax());
    assertEquals(2, heap.extractMax());
    assertEquals(1, heap.extractMax());
  }

  @Test
  public void testExtractMax() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    heap.insert(5);
    heap.insert(4);
    assertEquals(5, heap.extractMax());
    assertEquals(4, heap.extractMax());
    assertEquals(3, heap.extractMax());
    assertEquals(2, heap.extractMax());
    assertEquals(1, heap.extractMax());
    try {
      heap.extractMax();
      fail("Expected RuntimeException");
    } catch (RuntimeException e) {
      assertEquals("Heap is empty", e.getMessage());
    }
  }

  @Test
  public void testMax() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    heap.insert(5);
    heap.insert(4);
    assertEquals(5, heap.max());
    heap.extractMax();
    assertEquals(4, heap.max());
    heap.extractMax();
    assertEquals(3, heap.max());
    heap.extractMax();
    assertEquals(2, heap.max());
    heap.extractMax();
    assertEquals(1, heap.max());
  }

  @Test
  public void testEmpty() {
    MaxHeap heap = new MaxHeap(5);
    assertTrue(heap.empty());
    heap.insert(1);
    assertFalse(heap.empty());
    heap.extractMax();
    assertTrue(heap.empty());
  }

  @Test
  public void testFull() {
    MaxHeap heap = new MaxHeap(5);
    assertFalse(heap.full());
    heap.insert(1);
    assertFalse(heap.full());
    heap.insert(2);
    assertFalse(heap.full());
    heap.insert(3);
    assertFalse(heap.full());
    heap.insert(4);
    assertFalse(heap.full());
    heap.insert(5);
    assertTrue(heap.full());
  }

  @Test
  public void testInsertFull() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(5);
    heap.insert(4);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    try {
      heap.insert(6);
      fail("Expected RuntimeException");
    } catch (RuntimeException e) {
      assertEquals("Heap is full", e.getMessage());
    }
  }

  @Test
  public void testHeapIncreaseKey() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    heap.insert(5);
    heap.insert(4);
    heap.heapIncreaseKey(3, 6);
    assertEquals(6, heap.extractMax());
    assertEquals(5, heap.extractMax());
    assertEquals(4, heap.extractMax());
    assertEquals(3, heap.extractMax());
    assertEquals(2, heap.extractMax());
  }

  @Test
  public void testHeapIncreaseKeyInvalid() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    heap.insert(5);
    heap.insert(4);
    try {
      heap.heapIncreaseKey(3, 0);
      fail("Expected RuntimeException");
    } catch (RuntimeException e) {
      assertEquals("New key is smaller than current key", e.getMessage());
    }
  }

  @Test
  public void testToString() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(3);
    heap.insert(2);
    heap.insert(1);
    heap.insert(5);
    heap.insert(4);
    assertEquals("size = 5\n5 \n4 3 \n1 2 \n", heap.toString());
  }

  @Test
  public void testToStringEmpty() {
    MaxHeap heap = new MaxHeap(5);
    assertEquals("size = 0\n", heap.toString());
  }

  @Test
  public void testToStringSingle() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(1);
    assertEquals("size = 1\n1 \n", heap.toString());
  }

  @Test
  public void testToStringRepeated() {
    MaxHeap heap = new MaxHeap(5);
    heap.insert(1);
    heap.insert(1);
    heap.insert(1);
    assertEquals("size = 3\n1 \n1 1 \n", heap.toString());
  }

}