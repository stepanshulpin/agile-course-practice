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
        return 0;
    }
}
