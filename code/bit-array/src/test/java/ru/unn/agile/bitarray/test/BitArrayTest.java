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

        btr.setBit(4);
        btr.setBit(13);
        btr.setBit(19);
        btr.setBit(25);
        btr.setBit(34);
        btr.setBit(41);

        // act
        byte[]actual = btr.getRawArray();

        // assert
        byte[] reference = {16, 32, 8, 2, 4, 2};
        assertArrayEquals(reference, actual);
    }

    @Test
    public void canUnsetBitInBitArray() {
        // arrange
        BitArray btr = new BitArray(41);

        btr.setBit(4);

        btr.setBit(13);
        btr.unsetBit(13);

        btr.setBit(19);

        btr.setBit(25);
        btr.unsetBit(25);

        btr.setBit(34);

        btr.setBit(41);
        btr.unsetBit(41);

        // act
        byte[]actual = btr.getRawArray();

        // assert
        byte[] reference = {16, 0, 8, 0, 4, 0};
        assertArrayEquals(reference, actual);
    }

    @Test
    public void isEqualBitArrays() {
        // arrange
        BitArray btr_1 = new BitArray(41);
        BitArray btr_2 = new BitArray(41);

        btr_1.setBit(7);   btr_2.setBit(7);
        btr_1.setBit(11);  btr_2.setBit(11);
        btr_1.setBit(19);  btr_2.setBit(19);
        btr_1.setBit(26);  btr_2.setBit(26);
        btr_1.setBit(34);  btr_2.setBit(34);
        btr_1.setBit(40);  btr_2.setBit(40);

        // act && assert
        assertEquals(btr_1, btr_2);
    }
}
