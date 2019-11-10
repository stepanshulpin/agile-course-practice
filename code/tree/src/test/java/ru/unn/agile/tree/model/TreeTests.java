package ru.unn.agile.tree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTests {
    private Tree tree_;
    private double delta_ = 0.0001;
    @Before
    public void setUp() {
        tree_ = new Tree();
    }

    @Test
    public void canCreate() {
        assertNotNull(tree_);
    }

    @Test
    public void canAddElement() {
        final double number = 4.2;

        tree_.addElement(number);
    }

    @Test
    public void canGetElement() {
        final double number = 4.2;
        tree_.addElement(number);

        final double resultNumber = tree_.getElement();

        assertEquals(number, resultNumber, delta_);
    }
}
