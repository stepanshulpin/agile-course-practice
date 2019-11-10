package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeManipulationTests {
    private BinaryTree binaryTree_;

    private String  simpleData_ = "SimpleText";
    private int     simpleKey_  = 42;

    @Before
    public void setUp() {
        binaryTree_ = new BinaryTree();
        binaryTree_.add(simpleKey_, simpleData_);
    }

    @Test
    public void canFindElement() {
        final String result = binaryTree_.find(simpleKey_);

        assertEquals(simpleData_, result);
    }

    @Test
    public void canRemoveNode() {
        binaryTree_.remove(simpleKey_);
        final String result = binaryTree_.find(simpleKey_);

        assertNull(result);
    }

    @Test
    public void noErrorForFindNotExistsKey() {
        final int notExistsKey = 666;

        assertNull(binaryTree_.find(notExistsKey));
    }

    @Test
    public void noErrorForRemoveNotExistsKey() {
        final int notExistsKey = 666;

        assertFalse(binaryTree_.remove(notExistsKey));
    }
}
