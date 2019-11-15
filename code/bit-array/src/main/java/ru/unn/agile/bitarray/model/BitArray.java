package ru.unn.agile.bitarray.model;


import java.util.Arrays;
import java.util.Objects;

public class BitArray {
    private byte[] rawArray;
    private final int sizeByte = 8;

    public BitArray(final int countBit) {
        int lengthRawArray = -1;
        if (countBit > 0) {
            lengthRawArray = getNumElem(countBit);
        }
        rawArray = new byte[lengthRawArray];

        for (int i = 0; i < rawArray.length; i++)  {
            rawArray[i] = 0;
        }
    }

    public BitArray(final BitArray rawArray) {
        this.rawArray = rawArray.getRawArray();
    }

    public byte[] getRawArray() {
        return rawArray;
    }

    private int getNumElem(final int bit) {
        int numRawArray = bit / sizeByte;
        if (bit % sizeByte != 0) {
            numRawArray++;
        }
        return numRawArray;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BitArray)) return false;
        BitArray bitArray = (BitArray) o;
        return Arrays.equals(getRawArray(), bitArray.getRawArray());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sizeByte);
        result = 31 * result + Arrays.hashCode(getRawArray());
        return result;
    }

    public boolean isBit(final int bit) {
        int numElem = -1;
        if (bit > 0) {
            numElem = getNumElem(bit);
        }

        byte mask = 0;
        mask |= 1 << (bit % sizeByte);
        byte answer = (byte) (rawArray[numElem - 1] & mask);
        return answer > 0;
    }

    public void setBit(final int bit) {
        int numElem = -1;
        if (bit > 0) {
            numElem = getNumElem(bit);
        }
        rawArray[numElem - 1] |= 1 << (bit % sizeByte);
    }

    public void unsetBit(final int bit) {
        int numElem = -1;
        if (bit > 0) {
            numElem = getNumElem(bit);
        }
        rawArray[numElem - 1] &= ~(1 << (bit % sizeByte));
    }
}
