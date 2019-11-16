package ru.unn.agile.binarytree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeMultiNodeTests {
    private BinaryTree binaryTree;

    private final int     firstKey = 1;
    private final String  firstData = "FirstSimpleText";

    private final int     secondKey = 2;
    private final String  secondData = "SecondSimpleText";

    private final int     thirdKey = 3;
    private final String  thirdData = "ThirdSimpleText";

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    public void canAddTwoElements() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
    }

    @Test
    public void canFindTwoElements() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);

        final String firstResult  = binaryTree.find(firstKey);
        final String secondResult = binaryTree.find(secondKey);

        assertEquals(firstResult, firstData);
        assertEquals(secondResult, secondData);
    }

    @Test
    public void canAddChildToChild() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
        binaryTree.add(thirdKey, thirdData);

        assertEquals(thirdData, binaryTree.find(thirdKey));
    }

    @Test
    public void connectTwoChildIfMiddleDeleted() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
        binaryTree.add(thirdKey, thirdData);

        assertTrue(binaryTree.remove(secondKey));

        assertEquals(thirdData, binaryTree.find(thirdKey));
    }

    @Test
    public void canRemoveLastOneWithThreeNodes() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);
        binaryTree.add(thirdKey, thirdData);

        assertTrue(binaryTree.remove(secondKey));

        assertNull(binaryTree.find(secondKey));
    }

    @Test
    public void canRemoveRootChildShouldSurvive() {
        binaryTree.add(firstKey, firstData);
        binaryTree.add(secondKey, secondData);

        assertTrue(binaryTree.remove(firstKey));
        final String  childData = binaryTree.find(secondKey);

        assertEquals(secondData, childData);
    }

    @Test
    public void threeNodesTreeWillBeBalanced() {
        binaryTree.add(secondKey, secondData);
        binaryTree.add(firstKey, firstData);
        binaryTree.add(thirdKey, thirdData);

        assertEquals(2, binaryTree.getHeight());
    }

}
