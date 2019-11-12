package ru.unn.agile.complexnumbercalculation.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorComplexNumberTest {
    @Test
    public void createComplexNumberByDefaultNotNull() {
        CalculatorComplexNumber a = new CalculatorComplexNumber();

        assertNotNull(a);
    }

}
