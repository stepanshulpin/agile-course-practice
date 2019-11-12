package ru.unn.agile.Matrix.model;

public class Matrix {
    private final int size;

    public Matrix(final int size) {
        if (size == 0) {
            throw new IllegalArgumentException("Trying to create a matrix with zero size");
        } else if (size < 0) {
            throw new IllegalArgumentException("Trying to create a matrix with negative zero");
        }

        this.size = size;
    }
}
