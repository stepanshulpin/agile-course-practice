package ru.unn.agile.fractioncalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionCalculatorTest {

    @Test
    public void canCreateFractionCalculator() {
        var calculator = new FractionCalculator(1, 2);
        assertNotNull(calculator);
    }
}
