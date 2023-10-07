package ca.ucalgary.cpsc331.a1.test;

import org.junit.Test;
import static org.junit.Assert.*;
import ca.ucalgary.cpsc331.a1.MinHeap;

public class MinHeapTest {

    @Test
    public void testInsert() {
        MinHeap heap = new MinHeap(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(5, heap.extractMin());
    }

    @Test
    public void testExtractMin() {
        MinHeap heap = new MinHeap(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(5, heap.extractMin());
        try {
            heap.extractMin();
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Heap is empty", e.getMessage());
        }
    }

    @Test
    public void testMin() {
        MinHeap heap = new MinHeap(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        assertEquals(1, heap.min());
        heap.extractMin();
        assertEquals(2, heap.min());
        heap.extractMin();
        assertEquals(3, heap.min());
        heap.extractMin();
        assertEquals(4, heap.min());
        heap.extractMin();
        assertEquals(5, heap.min());
    }

    @Test
    public void testEmpty() {
        MinHeap heap = new MinHeap(5);
        assertTrue(heap.empty());
        heap.insert(1);
        assertFalse(heap.empty());
        heap.extractMin();
        assertTrue(heap.empty());
    }

    @Test
    public void testFull() {
        MinHeap heap = new MinHeap(5);
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
        MinHeap heap = new MinHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        try {
            heap.insert(6);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Heap is full", e.getMessage());
        }
    }

    @Test
    public void testHeapDecreaseKey() {
        MinHeap heap = new MinHeap(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        heap.heapDecreaseKey(3, 0);
        assertEquals(0, heap.extractMin());
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(4, heap.extractMin());
    }

    @Test
    public void testHeapDecreaseKeyInvalid() {
        MinHeap heap = new MinHeap(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        try {
            heap.heapDecreaseKey(3, 6);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("New key is larger than current key", e.getMessage());
        }
    }

}