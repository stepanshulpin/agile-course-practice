package ru.unn.agile.binarysearch.Model;

import ru.unn.agile.binarysearch.model.BinarySearch;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void canInitializeArrayForBinarySearch() {
        int[] inputArray = {0, 1, 2, 3, 4, 5};
        BinarySearch binarySearch = new BinarySearch(inputArray);

        assertEquals(inputArray, binarySearch.getArray());
    }

    @Test(expected = NullPointerException.class)
    public void canNullPointerException() {
        int[] inputArray = null;
        BinarySearch binarySearch = new BinarySearch(inputArray);
    }

    @Test
    public void canDoSimpleSearch() {
        int[] inputArray = {1};
        BinarySearch binarySearch = new BinarySearch(inputArray);
        int key = 1;
        int expectedPosition = 0;

        assertEquals(binarySearch.search(key), expectedPosition);
    }

    @Test
    public void canSearchElementInSortedArraySimple() {
        int[] inputArray = {1, 2, 3};
        BinarySearch binarySearch = new BinarySearch(inputArray);
        int key = 3;
        int expectedPosition = 2;

        assertEquals(binarySearch.search(key), expectedPosition);
    }
}
