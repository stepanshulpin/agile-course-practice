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
    public void canCreateMatrix() {
        var matrix = new Matrix(3);
        assertNotNull(matrix);
    }

    @Test
    public void cantCreateMatrixWithZeroSize() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Trying to create a matrix with zero size");

        var matrix = new Matrix(0);
    }

    @Test
    public void cantCreateMatrixWithNegativeSize() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Trying to create a matrix with negative zero");

        var matrix = new Matrix(-3);
    }

    @Test
    public void canGetSizeFromMatrix() {
        int matrixSize = 3;
        var matrix = new Matrix(matrixSize);
        assertEquals(matrixSize, matrix.getSize());
    }

    @Test
    public void checkGetSizeWithNewInit() {
        var matrix = new Matrix(4);
        assertEquals(4, matrix.getSize());
        matrix = new Matrix(12);
        assertEquals(12, matrix.getSize());
    }

    /*@Test
    public void canInitMatrixByArray() {
        int matrixSize = 2;
        var matrix = new Matrix(matrixSize);
        double[] array = new double[] {2.5, 1.6, 4.3, 7.8};
        matrix.initByArray(array);
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                assertEquals(array[i * matrixSize + j], matrix.getValue(i, j));
            }
        }
    }

    /*@Test
    public void canGetValueFromMatrix() {
        var matrix = new Matrix(3);
        assertEquals(3, matrix.getSize());
    }

    /*@Test
    public void addMatricesWithSameSize() {
        var matrix = new Matrix(4);
    }*/
}
