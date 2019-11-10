package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeCreateTests {
    private BinaryTree binaryTree_;

    private String  simpleData_ = "SimpleText";
    private int     simpleKey_  = 42;

    @Before
    public void setUp() {
        binaryTree_ = new BinaryTree();
    }

    @Test
    public void canCreate() {
        assertNotNull(binaryTree_);
    }

    @Test
    public void canAddElement() {
        binaryTree_.add(simpleKey_, simpleData_);
    }

    @Test
    public void noErrorOnEmptyTree() {
        final String result = binaryTree_.find(simpleKey_);

        assertNull(result);
    }
}
