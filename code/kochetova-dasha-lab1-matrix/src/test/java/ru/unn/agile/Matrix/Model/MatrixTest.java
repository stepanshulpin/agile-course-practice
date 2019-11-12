package ru.unn.agile.Matrix.Model;

import org.junit.Test;
import ru.unn.agile.Matrix.model.Matrix;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void canCreateSquareMatrix() {
        var squareMatrix = new Matrix(3);

        assertNotNull(squareMatrix);
    }
}
