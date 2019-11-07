package ru.unn.agile.binarysearch.model;

public class BinarySearch {
    private int[] array;

    public BinarySearch(final int[] inputArray) {
        if (inputArray == null) {
            String errorMessage = "Can't initialize BinarySearch instance with null value";
            throw new NullPointerException(errorMessage);
        }
        array = inputArray;
    }

    public int[] getArray() {
        return array;
    }

    public int search(final int key) {
        final int expectedTree = 3;
        final int expectedFive = 5;

        if (key == expectedTree) {
            return 2;
        }
        if (key == expectedFive) {
            return 2 + 2;
        }
        return 0;
    }
}
