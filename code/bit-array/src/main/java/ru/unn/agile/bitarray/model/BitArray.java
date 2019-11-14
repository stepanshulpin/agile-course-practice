package ru.unn.agile.bitarray.model;


import java.util.Arrays;

public class BitArray {
    private byte[] raw_array;

    public BitArray(int count_bit) {
        int length_raw_array = -1;
        if (count_bit > 0)
            length_raw_array = getNumElem(count_bit);
        raw_array = new byte[length_raw_array];

        for (int i=0; i<raw_array.length; i++)  {
            raw_array[i] = 0;
        }
    }

    public BitArray(BitArray bit_array) {
        raw_array = bit_array.getRawArray();
    }

    public byte[] getRawArray() {
        return raw_array;
    }
    
    private int getNumElem(int bit) {
        int num_raw_array = bit / 8;
        if (bit % 8 != 0) num_raw_array++;
        return num_raw_array;
    }

    public void setBit(int bit) {
        raw_array[getNumElem(bit) - 1] |= 1 << (bit % 8);
    }

    public void unsetBit(int bit) {
        raw_array[getNumElem(bit) - 1] &= ~(1 << (bit % 8));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitArray)) return false;
        BitArray bitArray = (BitArray) o;
        return Arrays.equals(raw_array, bitArray.raw_array);
    }
}
