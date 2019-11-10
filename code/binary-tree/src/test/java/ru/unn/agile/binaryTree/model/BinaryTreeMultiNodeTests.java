package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeMultiNodeTests {
    private BinaryTree binaryTree_;

    private int     firstKey_  = 1;
    private String  firstData_ = "FirstSimpleText";

    private int     secondKey_  = 2;
    private String  secondData_ = "SecondSimpleText";

    @Before
    public void setUp() {
        binaryTree_ = new BinaryTree();
    }

    @Test
    public void canAddTwoElements() {
        binaryTree_.add(firstKey_, firstData_);
        binaryTree_.add(secondKey_, secondData_);
    }

    @Test
    public void canFindTwoElements() {
        binaryTree_.add(firstKey_, firstData_);
        binaryTree_.add(secondKey_, secondData_);

        final String firstResult  = binaryTree_.find(firstKey_);
        final String secondResult = binaryTree_.find(secondKey_);

        assertEquals(firstResult, firstData_);
        assertEquals(secondResult, secondData_);
    }

    @Test
    public void canRemoveRootChildShouldSurvive() {
        binaryTree_.add(firstKey_, firstData_);
        binaryTree_.add(secondKey_, secondData_);

        assertTrue(binaryTree_.remove(firstKey_));
        final String  childData = binaryTree_.find(secondKey_);

        assertEquals(secondData_, childData);
    }

}
