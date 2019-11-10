package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTests {
    private BinaryTree binaryTree_;
    private double delta_ = 0.0001;

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
        final double number = 4.2;

        binaryTree_.add(number);
    }

    @Test
    public void canFindElement() {
        final double number = 4.2;

        binaryTree_.add(number);
        final double result = binaryTree_.find(number);

        assertEquals(number, result, delta_);
    }

    @Test
    public void canAddTwoElements() {
        final double firstNumber    = 4.2;
        final double secondNumber   = 3.14;

        binaryTree_.add(firstNumber);
        binaryTree_.add(secondNumber);
    }

    @Test
    public void canFindTwoElements() {
        final double firstNumber    = 4.2;
        final double secondNumber   = 3.14;

        binaryTree_.add(firstNumber);
        binaryTree_.add(secondNumber);
        final double firstResult  = binaryTree_.find(firstNumber);
        final double secondResult = binaryTree_.find(secondNumber);

        assertEquals(firstNumber, firstResult, delta_);
        assertEquals(secondNumber, secondResult, delta_);
    }
}
