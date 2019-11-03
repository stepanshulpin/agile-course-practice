package ru.unn.agile.figuresvolumecalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.unn.agile.figuresvolumecalculator.model.FiguresVolumeCalculator;

import static org.junit.Assert.*;


public class FiguresVolumeCalculatorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canCalculatePyramidVolume() {
        assertEquals(3, FiguresVolumeCalculator.pyramidVolumeCalculate(3, 3), 0.01);
    }

    @Test
    public void canThrowExceptionIfSquareIsNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Square can't be negative");
        FiguresVolumeCalculator.pyramidVolumeCalculate(-3, 3);
    }

    @Test
    public void canCalculatePyramidVolumeWithNegativeHeight() {
        assertEquals(3, FiguresVolumeCalculator.pyramidVolumeCalculate(3, -3), 0.01);
    }

    @Test
    public void canCalculateSphereVolume() {
        assertEquals(113.097, FiguresVolumeCalculator.sphereVolumeCalculate(3), 0.01);
    }

    @Test
    public void canThrowExceptionIfSphereRadiusIsNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Radius can't be negative");
        FiguresVolumeCalculator.sphereVolumeCalculate(-3);
    }

    @Test
    public void canCalculateCylinderVolume() {
        assertEquals(84.82,
                FiguresVolumeCalculator.cylinderVolumeCalculate(3, 3), 0.01);
    }

    @Test
    public void canCalculateCylinderVolumeWithNegativeHeight() {
        assertEquals(84.82,
                FiguresVolumeCalculator.cylinderVolumeCalculate(3, -3), 0.01);
    }

    @Test
    public void canThrowExceptionIfCylinderBaseRadiusIsNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Radius can't be negative");
        FiguresVolumeCalculator.cylinderVolumeCalculate(-3, 3);
    }






}
