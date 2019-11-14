package ru.unn.agile.bitarray.model;

public class BitArray {
    private byte[] raw_array;

    public BitArray(int count_bit) {
        int length_raw_array = count_bit / 8;
        if (count_bit % 8 != 0) length_raw_array++;
        this.raw_array = new byte[length_raw_array];
    }

    public byte[] getRawArray() {
        return this.raw_array;
    }
}
