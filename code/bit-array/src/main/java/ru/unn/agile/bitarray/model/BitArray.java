package ru.unn.agile.bitarray.model;


import java.util.Arrays;

public class BitArray {
    private byte[] rawArray;

    public BitArray(int countBit) {
        int lengthRawArray = -1;
        if (countBit > 0)
            lengthRawArray = getNumElem(countBit);
        rawArray = new byte[lengthRawArray];

        for (int i = 0; i< rawArray.length; i++)  {
            rawArray[i] = 0;
        }
    }

    public BitArray(BitArray rawArray) {
        this.rawArray = rawArray.getRawArray();
    }

    public byte[] getRawArray() {
        return rawArray;
    }
    
    private int getNumElem(int bit) {
        int numRawArray = bit / 8;
        if (bit % 8 != 0) numRawArray++;
        return numRawArray;
    }

    public boolean isBit(int bit) {
        int numElem = -1;
        if (bit > 0) numElem = getNumElem(bit);

        byte mask = 0;
        mask |= 1 << (bit % 8);
        byte answer = (byte) (rawArray[numElem - 1] & mask);
        return answer > 0;
    }

    public void setBit(int bit) {
        int numElem = -1;
        if (bit > 0) numElem = getNumElem(bit);
        rawArray[numElem - 1] |= 1 << (bit % 8);
    }

    public void unsetBit(int bit) {
        int numElem = -1;
        if (bit > 0) numElem = getNumElem(bit);
        rawArray[numElem - 1] &= ~(1 << (bit % 8));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BitArray)) return false;
        BitArray bitArray = (BitArray) o;
        return Arrays.equals(rawArray, bitArray.rawArray);
    }
}
