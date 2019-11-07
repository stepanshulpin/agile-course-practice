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
}
