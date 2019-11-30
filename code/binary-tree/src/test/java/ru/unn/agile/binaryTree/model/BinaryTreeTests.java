package ru.unn.agile.binarytree.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BinaryTreeTests {
    private BinaryTree binaryTree;
    private static Random randomGen;

    private int     simpleKey;
    private String  simpleData;

    private int arraySize;
    private int randBound;

    private void prepareRandomArrays(int[] randomKeys, String[] randomData, final int in_arraySize) {
        for (int i = 0; i < in_arraySize; ++i) {
            int randInt = randomGen.nextInt(randBound);
            randomKeys[i] = randInt;
            randomData[i] = Integer.toString(randInt);
        }
    }

    @Before
    public void setUp() {
        binaryTree  = new BinaryTree();

        simpleKey   = 42;
        simpleData  = "SimpleText";

        arraySize   = 10;

        randomGen   = new Random();
        randBound   = 1000;
    }

    /**
     * add tests
     */

    @Test
    public void add_NewData_NotNullRoot() {
        binaryTree.add(simpleKey, simpleData);

        assertNotEquals(null, binaryTree.getRootNode());
    }

    @Test
    public void add_SmallerDataToRoot_NotNullLeftChild() {
        final int value = 10;
        final int smaller_value = 5;
        binaryTree.add(value, Integer.toString(value));

        binaryTree.add(smaller_value, Integer.toString(smaller_value));

        Node leftChild = binaryTree.getRootNode().getLeftChild();
        assertNotEquals(null, leftChild);
    }

    @Test
    public void add_GreaterDataToRoot_NotNullRightChild() {
        final int value = 10;
        final int greater_value = 15;
        binaryTree.add(value, Integer.toString(value));

        binaryTree.add(greater_value, Integer.toString(greater_value));

        Node rightChild = binaryTree.getRootNode().getRightChild();
        assertNotEquals(null, rightChild);
    }

    @Test
    public void add_NewData_StoreCorrectRootValue() {
        binaryTree.add(simpleKey, simpleData);

        String rootValue = binaryTree.getRootNode().getValue();
        assertEquals(simpleData, rootValue);
    }

    @Test
    public void add_RandomValues_StoreAll() {
        int[]    inputKeys = new int[arraySize];
        String[] inputData = new String[arraySize];
        prepareRandomArrays(inputKeys, inputData, arraySize);

        for (int i = 0; i < arraySize; ++i) {
            binaryTree.add(inputKeys[i], inputData[i]);
        }

        String[] resultData = new String[arraySize];
        for (int i = 0; i < arraySize; ++i) {
            resultData[i] = binaryTree.find(inputKeys[i]);
        }

        assertArrayEquals(inputData, resultData);
    }

    @Test
    public void add_AfterRootDelete_StoreData() {
        binaryTree.add(simpleKey, simpleData);
        final int    secondKey  = 2;
        final String secondData = "SecondSimpleText";

        binaryTree.remove(simpleKey);
        binaryTree.add(secondKey, secondData);

        String rootValue = binaryTree.getRootNode().getValue();
        assertEquals(secondData, rootValue);
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

    @Test
    public void remove_InTreeWithRootAndChild_RootNotNull() {
        final int rootKey   = 1;
        final int childKey  = 2;
        binaryTree.add(rootKey, Integer.toString(rootKey));
        binaryTree.add(childKey, Integer.toString(childKey));

        binaryTree.remove(rootKey);

        assertNotEquals(null, binaryTree.getRootNode());
    }

    @Test
    public void remove_MiddleKey_RestConnected() {
        final int valueOne  = 1;
        final int valueTwo  = 2;
        final int valueTree = 3;
        binaryTree.add(valueOne, Integer.toString(valueOne));
        binaryTree.add(valueTwo, Integer.toString(valueTwo));
        binaryTree.add(valueTree, Integer.toString(valueTree));

        binaryTree.remove(valueTwo);

        Node childOfTheFirst = binaryTree.getRootNode().getRightChild();
        assertNotEquals(null, childOfTheFirst);
    }


    /**
     *  getHeight tests
     */

    @Test
    public void getHeight_InEmptyTree_Return0() {
        assertEquals(0, binaryTree.getHeight());
    }

    @Test
    public void getHeight_InTreeWithOneData_Return1() {
        binaryTree.add(simpleKey, simpleData);
        assertEquals(1, binaryTree.getHeight());
    }

    @Test
    public void getHeight_InTwoValuesRightBranch_Return2() {
        final int amountOfValues = 2;
        final int valueOne  = 1;
        final int valueTwo  = 2;
        binaryTree.add(valueOne, Integer.toString(valueOne));
        binaryTree.add(valueTwo, Integer.toString(valueTwo));

        final int height = binaryTree.getHeight();

        assertEquals(amountOfValues, height);
    }

    @Test
    public void getHeight_InTwoValuesLeftBranch_Return2() {
        final int amountOfValues = 2;
        final int valueOne  = 10;
        final int valueTwo  = 5;
        binaryTree.add(valueOne, Integer.toString(valueOne));
        binaryTree.add(valueTwo, Integer.toString(valueTwo));

        final int height = binaryTree.getHeight();

        assertEquals(amountOfValues, height);
    }

    @Test
    public void getHeight_InWithRightHighest_ReturnRightHeight() {
        final int valueRoot         = 10;
        final int valueRightFirst   = 20;
        final int valueRightSecond  = 30;
        final int valueLeftFirst    = 5;
        binaryTree.add(valueRoot, Integer.toString(valueRoot));
        binaryTree.add(valueRightFirst, Integer.toString(valueRightFirst));
        binaryTree.add(valueRightSecond, Integer.toString(valueRightSecond));
        binaryTree.add(valueLeftFirst, Integer.toString(valueLeftFirst));

        final int resultHeight = binaryTree.getHeight();

        final int expectedHeight = 3;
        assertEquals(expectedHeight, resultHeight);
    }
}
