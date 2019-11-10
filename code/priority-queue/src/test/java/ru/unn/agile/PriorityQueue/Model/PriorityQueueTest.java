package ru.unn.agile.PriorityQueue.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void canBeConstructed() {
        var pq = new PriorityQueue<Integer>();
        assertNotEquals(null, pq);
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
        assertEquals(0, size);
    }

    @Test
    public void canCheckNotNullSize() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(2);

        var size = pq.size();
        assertEquals(2, size);
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

        assertEquals(1, pq.size());
    }

    @Test
    public void canPopMultipleElems() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(1);

        int v1 = pq.pop();
        int v2 = pq.pop();

        assertEquals(1, v1);
        assertEquals(1, v2);
    }

    @Test
    public void canHandleCorrectPriority() {
        var pq = new PriorityQueue<Integer>();

        pq.push(1);
        pq.push(4);
        pq.push(3);
        pq.push(2);

        int v1 = pq.pop();
        int v2 = pq.pop();
        int v3 = pq.pop();
        int v4 = pq.pop();

        assertEquals(4, v1);
        assertEquals(3, v2);
        assertEquals(2, v3);
        assertEquals(1, v4);
    }

    @Test
    public void canInformAboutEmptyQueue() {
        var pq = new PriorityQueue<Integer>();
        var val = pq.pop();
        assertEquals(null, val);
    }

}
