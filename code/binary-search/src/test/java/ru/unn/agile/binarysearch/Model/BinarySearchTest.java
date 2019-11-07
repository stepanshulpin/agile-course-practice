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
}
