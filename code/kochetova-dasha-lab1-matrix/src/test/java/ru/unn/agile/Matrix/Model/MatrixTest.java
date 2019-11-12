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
        var matrix = new Matrix(3);
        assertEquals(3, matrix.getSize());
    }

    /*@Test
    public void canGetValueFromMatrix() {
        var matrix = new Matrix(3);
        assertEquals(3, matrix.size);
    }

    /*@Test
    public void canInitMatrixByRandomValue() {
        var matrix = new Matrix(3);
        double startValue = 0.0;
        double endValue = 10.0;
        matrix.initByRandomValue(startValue, endValue);
        for (int )
    }

    /*@Test
    public void addMatricesWithSameSize() {
        var matrix = new Matrix(4);
    }*/
}
