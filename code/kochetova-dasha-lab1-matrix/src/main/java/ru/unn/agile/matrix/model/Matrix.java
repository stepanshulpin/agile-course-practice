package ru.unn.agile.Matrix.model;

public class Matrix {

    public enum ExceptionMessage {
        ILLEGAL_ARG_EXC_EQUAL_ZERO("Trying to create a matrix with zero size"),
        ILLEGAL_ARG_EXC_LESS_ZERO("Trying to create a matrix with negative zero"),
        INDEX_OUT_BOUNDS_INPUT_ARRAY("Array size was more then matrix size");

        private final String text;

        ExceptionMessage(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private final int size;
    private double[] matrix;

    public Matrix(final int size) {
        if (size == 0) {
            throw new IllegalArgumentException(
                ExceptionMessage.ILLEGAL_ARG_EXC_EQUAL_ZERO.toString());
        } else if (size < 0) {
            throw new IllegalArgumentException(
                ExceptionMessage.ILLEGAL_ARG_EXC_LESS_ZERO.toString());
        }

        matrix = new double[size * size];
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void initByArray(final double[] array) {
        if (array.length > size * size) {
            throw new IndexOutOfBoundsException(
                ExceptionMessage.INDEX_OUT_BOUNDS_INPUT_ARRAY.toString());
        }

        for (int i = 0; i < array.length; i++) {
            this.matrix[i] = array[i];
        }
    }

    public double getValue(final int i, final int j) {
        return this.matrix[i * size + j];
    }
}
