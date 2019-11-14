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

    @Test(expected = NegativeArraySizeException.class)
    public void canInitBitArrayWithNegative() {
        new BitArray(-10);
    }

    @Test
    public void isZeroAfterInitBitArray() {
        // arrange
        BitArray btr = new BitArray(101);

        // act
        byte[] raw_array = btr.getRawArray();

        // assert
        for (int elem : raw_array)
            assertEquals(elem, 0);
    }

    @Test
    public void canSetBitInBitArray() {
        // arrange
        BitArray btr = new BitArray(41);

        // act
        btr.setBit(4);
        btr.setBit(13);
        btr.setBit(19);
        btr.setBit(25);
        btr.setBit(34);
        btr.setBit(41);
        byte[]actual = btr.getRawArray();

        // assert
        byte[] reference = {16, 32, 8, 2, 4, 2};
        for(int i = 0; i < actual.length; i++)
            assertEquals(reference[i], actual[i]);
    }

}
