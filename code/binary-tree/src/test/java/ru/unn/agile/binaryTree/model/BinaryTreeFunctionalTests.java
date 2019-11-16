package ru.unn.agile.binarytree.model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Random;

import static org.junit.Assert.*;

public class BinaryTreeFunctionalTests {
    private BinaryTree binaryTree;

    private int     simpleKey   = 1;
    private String  simpleData  = "FirstSimpleText";

    private int bound = 1000;
    private int arrSize = 10;
    private static Random randomGen = new Random();

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
        final int size = 10;
        for (int i = 0; i < size; ++i) {
            binaryTree.add(i, Integer.toString(i));
        }

        for (int i = 0; i < size; ++i) {
            assertEquals(Integer.toString(i), binaryTree.find(i));
        }
    }

    @Test
    public void canAddTenRemoveMiddleAndGetRest() {
        final int middleKey = 5;
        final int size      = 10;

        for (int i = 0; i < size; ++i) {
            binaryTree.add(i, Integer.toString(i));
        }

        assertTrue(binaryTree.remove(middleKey));

        for (int i = 0; i < size; ++i) {
            if (i != middleKey) {
                assertEquals(Integer.toString(i), binaryTree.find(i));
            } else {
                assertNull(binaryTree.find(i));
            }
        }
    }

    @Test
    public void canFillWithRandom() {
        for (int i = 0; i < arrSize; ++i) {
            int randInt = randomGen.nextInt(bound);
            binaryTree.add(randInt, Integer.toString(randInt));
        }
    }

    @Test
    public void canFillWithRandomAndFind() {
        int[] storage = new int[arrSize];

        for (int i = 0; i < arrSize; ++i) {
            int randInt = randomGen.nextInt(bound);
            storage[i] = randInt;
            binaryTree.add(randInt, Integer.toString(randInt));
        }

        for (int i = 0; i < arrSize; ++i) {
            assertEquals(Integer.toString(storage[i]), binaryTree.find(storage[i]));
        }
    }

    @Test
    public void canRemoveRandomAndFindRest() {
        int[] storage = new int[arrSize];
        int elemToRemove = 0;

        for (int i = 0; i < arrSize; ++i) {
            int randInt = randomGen.nextInt(bound);
            if (i == arrSize/2) {
                elemToRemove = randInt;
                System.out.println(elemToRemove);
            } else {
                storage[i] = randInt;
            }
            binaryTree.add(randInt, Integer.toString(randInt));
        }

        assertTrue(binaryTree.remove(elemToRemove));

        for (int i = 0; i < arrSize - 1; ++i) {
            assertEquals(Integer.toString(storage[i]), binaryTree.find(storage[i]));
        }
    }

}
