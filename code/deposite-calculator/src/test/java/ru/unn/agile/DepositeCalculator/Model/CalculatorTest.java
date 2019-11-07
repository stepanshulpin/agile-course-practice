package ru.unn.agile.DepositeCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private final double delta = 0.0001;

    @Test
    public void caclYearDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.calculate(100, 10);

        assertEquals(110, depositeRes, delta);
    }
}