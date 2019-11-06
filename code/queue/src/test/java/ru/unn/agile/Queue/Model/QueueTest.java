package ru.unn.agile.Queue.Model;

import org.junit.Test;
import ru.unn.agile.Queue.model.Queue;

import static org.junit.Assert.*;


public class QueueTest {
    @Test
    public void canCreateQueue() {
        Queue<Integer> newQueue = new Queue<>();

        assertNotEquals(null, newQueue);
    }

    @Test
    public void canPushIntegerElementToQueue() {
        Queue<Integer> newQueue = new Queue<>();
        Integer expectedElement = 1;

        newQueue.push(expectedElement);

        assertEquals(expectedElement, newQueue.getTail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenPushNullElementToQueue() {
        Queue<Integer> newQueue = new Queue<>();

        newQueue.push(null);
    }

    @Test
    public void canPushDoublerElementToQueue() {
        Queue<Double> newQueue = new Queue<>();
        Double expectedElement = 1.0;

        newQueue.push(expectedElement);

        assertEquals(expectedElement, newQueue.getTail());
    }

    @Test
    public void isQueueWithoutIntegerElementsEmptiness() {
        Queue<Integer> newQueue = new Queue<>();

        assertTrue(newQueue.isEmpty());
    }

    @Test
    public void isQueueWithoutDoubleElementsEmptiness() {
        Queue<Double> newQueue = new Queue<>();

        assertTrue(newQueue.isEmpty());
    }

    @Test
    public void isQueueWithOneIntegerElementNotEmpty() {
        Queue<Integer> newQueue = new Queue<>();
        newQueue.push(1);

        assertFalse(newQueue.isEmpty());
    }

    @Test
    public void isQueueWithOneDoubleElementNotEmpty() {
        Queue<Double> newQueue = new Queue<>();
        newQueue.push(1.0);

        assertFalse(newQueue.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void throwWhenGetTailIntegerElementFromEmptyQueue() {
        Queue<Integer> newQueue = new Queue<>();

        newQueue.getTail();
    }

    @Test(expected = NullPointerException.class)
    public void throwWhenGetTailDoubleElementFromEmptyQueue() {
        Queue<Double> newQueue = new Queue<>();

        newQueue.getTail();
    }
}
