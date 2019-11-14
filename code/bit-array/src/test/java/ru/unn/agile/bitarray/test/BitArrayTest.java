package ru.unn.agile.bitarray.test;

import org.junit.Test;
import ru.unn.agile.bitarray.model.BitArray;

import static org.junit.Assert.*;

public class BitArrayTest {

    @Test
    public void canInitBitArray() {
        // arrange
        BitArray btr = new BitArray(10);

        // act
        byte[] raw_array = btr.getRawArray();

        // assert
        assertEquals(raw_array.length, 2);
    }
}
