package ru.unn.agile.binarytree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeManipulationTests {
    private BinaryTree binaryTree;

    private int     simpleKey  = 42;
    private String  simpleData = "SimpleText";

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.add(simpleKey, simpleData);
    }

    @Test
    public void canFind() {
        final String result = binaryTree.find(simpleKey);

        assertEquals(simpleData, result);
    }

    @Test
    public void canRemove() {
        assertTrue(binaryTree.remove(simpleKey));
    }

    @Test
    public void cannotFindRemoved() {
        binaryTree.remove(simpleKey);
        final String result = binaryTree.find(simpleKey);

        assertNull(result);
    }

    @Test
    public void cannotFindNotExistsKey() {
        final int notExistsKey = 666;

        assertNull(binaryTree.find(notExistsKey));
    }

    @Test
    public void cannotRemoveNotExistsKey() {
        final int notExistsKey = 666;

        assertFalse(binaryTree.remove(notExistsKey));
    }

    @Test
    public void canGetHeight() {
        assertEquals(1, binaryTree.getHeight());
    }

}
