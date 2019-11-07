package ru.unn.agile.DepositeCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private final double delta = 0.0001;

    @Test
    public void caclYearDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.calculate(100, 10, 12);

        assertEquals(110, depositeRes, delta);
    }

    @Test
    public void cacl2YearDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.calculate(100, 10, 24);

        assertEquals(120, depositeRes, delta);
    }

    @Test
    public void cacl6MonthDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.calculate(200, 10, 6);

        assertEquals(210, depositeRes, delta);
    }

    @Test
    public void caclMonthDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.calculate(144, 50, 1);

        assertEquals(150, depositeRes, delta);
    }
}