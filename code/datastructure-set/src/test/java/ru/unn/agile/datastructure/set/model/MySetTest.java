package ru.unn.agile.datastructure.set.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySetTest {

    private final double delta = 0.001;

    @Test
    public void canGiveImagineNumber() {
        double imagine = 0.0;
        MySet z1 = new MySet(1, imagine);
        assertEquals(imagine, z1.getImaginary(), delta);
    }

    @Test
    public void canGiveRealNumber() {
        double real = 0.0;
        MySet z1 = new MySet(real, 1);
        assertEquals(real, z1.getReal(), delta);
    }

    @Test
    public void canGiveHashCode() {
        MySet z1 = new MySet(0, 0);
        assertTrue((z1.hashCode() >= 0));
    }

    @Test
    public void canInitWithoutParameters() {
        MySet z1 = new MySet();
        assertEquals(new MySet(0, 0), z1);
    }

    @Test
    public void canCompareWithObject() {
        assertFalse(new MySet().equals(new Object()));
    }

    @Test
    public void canAddComplexNumbers() {
        // Arrange
        MySet z1 = new MySet(1, 0);
        MySet z2 = new MySet(0, 1);

        // Act
        MySet z = z1.add(z2);

        // Assert
        assertEquals(new MySet(1, 1), z);
    }

    @Test
    public void canCreateComplexNumberWithInitialValues() {
        MySet number = new MySet(1, 1);
        assertNotNull(number);
    }

    @Test
    public void canSetInitialRealValue() {
        MySet number = new MySet(1, 2);
        assertEquals(1.0, number.getReal(), delta);
    }

    @Test
    public void canSetInitialImaginaryValue() {
        MySet number = new MySet(1, 2);
        assertEquals(2.0, number.getImaginary(), delta);
    }

    @Test
    public void areEqualNumbersEqual() {
        MySet z1 = new MySet(3.14, 2.73);
        MySet z2 = new MySet(3.14, 2.73);
        assertTrue(z1.equals(z2));
    }

    @Test
    public void areNumbersWithDifferentRealPartNotEqual() {
        MySet z1 = new MySet(1.00, 2.73);
        MySet z2 = new MySet(3.14, 2.73);
        assertFalse(z1.equals(z2));
    }

    @Test
    public void areNumbersWithDifferentImaginaryPartNotEqual() {
        MySet z1 = new MySet(3.14, 1.00);
        MySet z2 = new MySet(3.14, 2.73);
        assertFalse(z1.equals(z2));
    }

    @Test
    public void canAddNumbers() {
        MySet z1 = new MySet(1, 2);
        MySet z2 = new MySet(3, 4);
        MySet sum = z1.add(z2);
        assertEquals(new MySet(4, 6), sum);
    }

    @Test
    public void canAddNumbersWithNegativePart() {
        MySet z1 = new MySet(-1, 2);
        MySet z2 = new MySet(3, -4);
        MySet sum = z1.add(z2);
        assertTrue(sum.equals(new MySet(2, -2)));
    }

    @Test
    public void canFormatSumOfNumbersWithNegativePart() {
        MySet z1 = new MySet(1.2, 2.3);
        MySet z2 = new MySet(-10.4, -20.5);
        MySet sum = z1.add(z2);
        assertEquals("-9.2 - 18.2i", sum.toString());
    }

    @Test
    public void canMultiplyNumbers() {
        MySet z1 = new MySet(1, 2);
        MySet z2 = new MySet(3, 4);
        MySet sum = z1.multiply(z2);
        assertEquals(new MySet(-5, 10), sum);
    }

    @Test
    public void canConvertStringToComplexNumber() {
        String re = "10";
        String im = "20";
        MySet z = new MySet(re, im);

        assertEquals(new MySet(10, 20), z);
    }

    @Test
    public void canConvertScientificStringToComplexNumber() {
        String re = "3.14";
        String im = "-1e3";
        MySet z = new MySet(re, im);

        assertEquals(new MySet(3.14, -1e3), z);
    }
}
