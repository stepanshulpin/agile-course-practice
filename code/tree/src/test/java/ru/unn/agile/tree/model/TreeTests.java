package ru.unn.agile.tree.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTests {
    @Test
    public void canCreate() {
        Tree tree = new Tree();

        assertNotNull(tree);
    }

    @Test
    public void canAddElement() {
        Tree tree = new Tree();
        final float number = 0;

        tree.addElement(number);
    }
}
