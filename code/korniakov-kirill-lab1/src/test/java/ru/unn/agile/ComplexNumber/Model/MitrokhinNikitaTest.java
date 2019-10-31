package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class MitrokhinNikitaTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(2, 1), z);
    }