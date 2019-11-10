package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeFunctionalTests {
    private BinaryTree binaryTree;

    private int     simpleKey   = 1;
    private String  simpleData  = "FirstSimpleText";

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void canAddAfterDeletingRoot() {
        binaryTree.add(simpleKey, simpleData);
        final int    secondKey  = 2;
        final String secondData = "SecondSimpleText";

        assertTrue(binaryTree.remove(simpleKey));

        binaryTree.add(secondKey, secondData);
    }

    @Test
    public void canAddTenValuesAndGetIt() {
        for (int i = 0; i < 10; ++i) {
            binaryTree.add(i, Integer.toString(i));
        }

        for (int i = 0; i < 10; ++i) {
            assertEquals(Integer.toString(i), binaryTree.find(i));
        }
    }

    @Test
    public void canAddTenRemoveMiddleAndGetRest() {
        final int middleKey = 2;
        final int size      = 4;

        for (int i = 0; i < size; ++i) {
            binaryTree.add(i, Integer.toString(i));
        }

        assertTrue(binaryTree.remove(middleKey));

        for (int i = 0; i < size; ++i) {
            System.out.println(i);
            if (i != middleKey) {
                assertEquals(Integer.toString(i), binaryTree.find(i));
            } else {
                assertNull(binaryTree.find(i));
            }
        }
    }

}
