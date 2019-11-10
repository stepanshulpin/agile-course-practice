package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeFunctionalTests {
    private BinaryTree binaryTree;

    private int     firstKey = 1;
    private String  firstData = "FirstSimpleText";

    private int     secondKey = 2;
    private String  secondData = "SecondSimpleText";

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.add(firstKey, firstData);
    }

    @Test
    public void canAddAfterDeletingRoot() {
        assertTrue(binaryTree.remove(firstKey));

        binaryTree.add(secondKey, secondData);
    }
}
