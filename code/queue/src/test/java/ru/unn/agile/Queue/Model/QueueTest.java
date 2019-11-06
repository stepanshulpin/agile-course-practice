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
}
