package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeFunctionalTests {
    private BinaryTree binaryTree_;

    private int     firstKey_  = 1;
    private String  firstData_ = "FirstSimpleText";

    private int     secondKey_  = 2;
    private String  secondData_ = "SecondSimpleText";

    @Before
    public void setUp() {
        binaryTree_ = new BinaryTree();
        binaryTree_.add(firstKey_, firstData_);
    }

    @Test
    public void canAddAfterDeletingRoot() {
        assertTrue(binaryTree_.remove(firstKey_));

        binaryTree_.add(secondKey_, secondData_);
    }
}
