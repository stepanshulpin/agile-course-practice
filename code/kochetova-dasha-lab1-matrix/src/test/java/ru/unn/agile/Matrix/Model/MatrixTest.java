package ru.unn.agile.Matrix.Model;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import ru.unn.agile.Matrix.model.Matrix;

import static org.junit.Assert.*;


public class MatrixTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canCreateSquareMatrix() {
        var squareMatrix = new Matrix(3);
        assertNotNull(squareMatrix);
    }

    @Test
    public void cantCreateSquareMatrixWithZeroSize() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Trying to create a matrix with size zero");

        var squareMatrix = new Matrix(0);
    }
}
