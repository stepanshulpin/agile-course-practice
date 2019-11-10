package ru.unn.agile.PriorityQueue.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void canBeConstructed() {
        var pq = new PriorityQueue<Integer>();
        assertNotEquals(pq, null);
    }

    @Test
    public void canHandleEmptyQueue() {
        var pq = new PriorityQueue<Integer>();
        boolean empty = pq.isEmpty();
        assertTrue(empty);
    }

    @Test
    public void canCheckNullSize() {
        var pq = new PriorityQueue<Integer>();
        var size = pq.size();
        assertEquals(size, 0);
    }

    @Test
    public void canCheckNotNullSize() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);

        var size = pq.size();
        assertEquals(size, 2);
    }

    @Test
    public void canPushAndPopSingleElement() {
        var pq = new PriorityQueue<Integer>();

        Integer elem1 = 1;
        pq.push(1);
        Integer elem2 = pq.pop();

        assertEquals(elem1, elem2);
    }

    @Test
    public void canHandleDecrease() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);
        pq.pop();

        assertEquals(pq.size(), 1);
    }

    @Test
    public void canPopMultipleElems() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);

        int v1 = pq.pop();
        int v2 = pq.pop();

        assertEquals(v1, 2);
        assertEquals(v2, 1);
    }

}
