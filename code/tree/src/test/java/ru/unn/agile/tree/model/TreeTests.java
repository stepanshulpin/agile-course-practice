package ru.unn.agile.tree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTests {
    private Tree tree_;

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
        final float number = 0;

        tree_.addElement(number);
    }
    }
}
