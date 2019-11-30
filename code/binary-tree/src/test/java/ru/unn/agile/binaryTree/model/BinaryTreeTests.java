package ru.unn.agile.binarytree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTests {
    private BinaryTree binaryTree;
    private int     simpleKey  = 42;
    private String  simpleData = "SimpleText";
    
    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    /**
     * Add tests
     */

    @Test
    public void add_NewData_NotNullRoot() {
        binaryTree.add(simpleKey, simpleData);

        assertNotEquals(null, binaryTree.getRootNode());
    }

    @Test
    public void add_NewData_StoreCorrectRootData() {
        binaryTree.add(simpleKey, simpleData);

        assertEquals(simpleData, binaryTree.getRootNode().getValue());
    }

    /**
     * Find tests
     */

    @Test
    public void find_InEmptyTree_ReturnNull() {
        final String result = binaryTree.find(simpleKey);

        assertNull(result);
    }

    @Test
    public void find_InTreeWithData_ReturnData() {
        binaryTree.add(simpleKey, simpleData);
        final String result = binaryTree.find(simpleKey);

        assertEquals(simpleData, result);
    }

    @Test
    public void find_AfterRemove_ReturnNull() {
        binaryTree.add(simpleKey, simpleData);

        binaryTree.remove(simpleKey);
        final String result = binaryTree.find(simpleKey);

        assertNull(result);
    }
    @Test
    public void find_NotExistingKey_ReturnNull() {
        final int notExistsKey = 666;

        final String result = binaryTree.find(notExistsKey);

        assertNull(result);
    }

    /**
     * Remove tests
     */

    @Test
    public void remove_NotExistsKey_ReturnFalse() {
        assertFalse(binaryTree.remove(simpleKey));
    }

    @Test
    public void remove_ExistingKey_ReturnTrue() {
        binaryTree.add(simpleKey, simpleData);

        assertTrue(binaryTree.remove(simpleKey));
    }

    /**
     *  getHeight tests
     */

    @Test
    public void getHeight_InTreeWithOneData_Return1() {
        binaryTree.add(simpleKey, simpleData);
        assertEquals(1, binaryTree.getHeight());
    }
}
