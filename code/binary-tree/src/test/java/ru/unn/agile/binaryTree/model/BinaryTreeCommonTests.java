package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeCommonTests {
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
    public void canFindElement() {
        binaryTree_.add(simpleKey_, simpleData_);
        final String result = binaryTree_.find(simpleKey_);

        assertEquals(simpleData_, result);
    }

    @Test
    public void noErrorOnEmptyTree() {
        final String result = binaryTree_.find(simpleKey_);

        assertNull(result);
    }

    @Test
    public void canRemoveNode() {
        binaryTree_.add(simpleKey_, simpleData_);

        binaryTree_.remove(simpleKey_);
        final String result = binaryTree_.find(simpleKey_);

        assertNull(result);
    }
}
