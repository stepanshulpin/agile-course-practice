package ru.unn.agile.stack.Model;

import org.junit.Test;
import ru.unn.agile.stack.model.Stack;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void canCreateStack() {
        Stack stack = new Stack();
        assertTrue(stack.isStackCreated());
    }

    @Test(expected = Test.None.class)
    public void canPushIntegerToStack() {
        Stack<Integer> stack = new Stack<>();
        int valueToAdd = 5;

        stack.push(valueToAdd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowWhenPushNullElementToSTack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(null);
    }

    @Test
    public void canPopItemFromStack() {
        Stack<Integer> stack = new Stack<>();
        Integer valueToAdd = 5;

        stack.push(valueToAdd);
        Integer actualItem = stack.pop();
        assertEquals(valueToAdd, actualItem);
    }
}
