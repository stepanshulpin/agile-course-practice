package ru.unn.agile.figuresvolumecalculator;


import org.junit.Test;
import ru.unn.agile.figuresvolumecalculator.model.FiguresVolumeCalculator;

import static org.junit.Assert.*;


public class FiguresVolumeCalculatorTest {

    private final double delta = 1e-2;

    @Test
    public void canCalculatePyramidVolume() {
        assertEquals(3, FiguresVolumeCalculator.pyramidVolumeCalculate(3, 3), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionIfSquareIsNegative() {
        FiguresVolumeCalculator.pyramidVolumeCalculate(-3, 3);
    }

    @Test
    public void canCalculatePyramidVolumeWithNegativeHeight() {
        assertEquals(3, FiguresVolumeCalculator.pyramidVolumeCalculate(3, -3), delta);
    }

    @Test
    public void canCalculateSphereVolume() {
        assertEquals(113.097, FiguresVolumeCalculator.sphereVolumeCalculate(3), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionIfSphereRadiusIsNegative() {
        FiguresVolumeCalculator.sphereVolumeCalculate(-3);
    }

    @Test
    public void canCalculateCylinderVolume() {
        assertEquals(84.82,
                FiguresVolumeCalculator.cylinderVolumeCalculate(3, 3), delta);
    }

    @Test
    public void canCalculateCylinderVolumeWithNegativeHeight() {
        assertEquals(84.82,
                FiguresVolumeCalculator.cylinderVolumeCalculate(3, -3), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionIfCylinderBaseRadiusIsNegative() {
        FiguresVolumeCalculator.cylinderVolumeCalculate(-3, 3);
    }

    @Test
    public void canCalculateConeVolumeWithZeroHeight() {
        assertEquals(0, FiguresVolumeCalculator.coneVolumeCalculate(1, 0), delta);
    }

    @Test
    public void canCalculateConeVolumeWithArbitraryPositiveParams() {
        assertEquals(28.27, FiguresVolumeCalculator.coneVolumeCalculate(3, 3), delta);
    }

    @Test
    public void canCalculateConeVolumeWithNegativeHeight() {
        assertEquals(28.27, FiguresVolumeCalculator.coneVolumeCalculate(3, -3), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionIfConeBaseRadiusIsNegative() {
        FiguresVolumeCalculator.coneVolumeCalculate(-3, 3);
    }

    @Test
    public void canCalculateParallelepipedVolumeWithZeroHeight() {
        assertEquals(0, FiguresVolumeCalculator.parallelepipedVolumeCalculate(1, 0), delta);
    }

    @Test
    public void canCalculateParallelepipedVolumeWithArbitraryPositiveParams() {
        assertEquals(9, FiguresVolumeCalculator.parallelepipedVolumeCalculate(3, 3), delta);
    }

    @Test
    public void canCalculateParallelepipedVolumeWithNegativeHeight() {
        assertEquals(9, FiguresVolumeCalculator.parallelepipedVolumeCalculate(3, -3), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canThrowExceptionIfParallelepipedBaseSquareIsNegative() {
        FiguresVolumeCalculator.parallelepipedVolumeCalculate(-3, 3);
    }

}
