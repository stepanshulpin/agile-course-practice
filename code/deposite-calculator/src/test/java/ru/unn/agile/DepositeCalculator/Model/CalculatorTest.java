package ru.unn.agile.DepositeCalculator.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private final double delta = 0.0001;

    @Test
    public void caclYearDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(100)
                .setPercent(10)
                .setPeriod(DepositeTimeType.YEAR, 1)
                .calculate();

        assertEquals(110, depositeRes, delta);
    }

    @Test
    public void cacl2YearDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(100)
                .setPercent(10)
                .setPeriod(DepositeTimeType.YEAR, 2)
                .calculate();

        assertEquals(120, depositeRes, delta);
    }

    @Test
    public void cacl6MonthDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(200)
                .setPercent(10)
                .setPeriod(DepositeTimeType.MONTH, 6)
                .calculate();

        assertEquals(210, depositeRes, delta);
    }

    @Test
    public void caclMonthDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(144)
                .setPercent(50)
                .setPeriod(DepositeTimeType.MONTH, 1)
                .calculate();

        assertEquals(150, depositeRes, delta);
    }

    @Test
    public void caclDayDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(730)
                .setPercent(50)
                .setPeriod(DepositeTimeType.DAY, 1)
                .calculate();

        assertEquals(731, depositeRes, delta);
    }

    @Test
    public void caclHalfYearDaysDepositeWithoutCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(66430)
                .setPercent(10)
                .setPeriod(DepositeTimeType.DAY, 182)
                .calculate();

        assertEquals(69742.4, depositeRes, delta);
    }

    @Test
    public void caclYearDepositeWithCapitalization() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(100)
                .setPercent(10)
                .setPeriod(DepositeTimeType.YEAR, 1)
                .setCapitalizationPeriod(DepositeTimeType.YEAR)
                .calculate();

        assertEquals(110, depositeRes, delta);
    }

    @Test
    public void cacl3YearDepositeWithCapitalizationPerYear() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(1000)
                .setPercent(10)
                .setPeriod(DepositeTimeType.YEAR, 3)
                .setCapitalizationPeriod(DepositeTimeType.YEAR)
                .calculate();

        assertEquals(1331, depositeRes, delta);
    }

    @Test
    public void cacl3MonthDepositeWithCapitalizationPerYear() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(1000)
                .setPercent(60)
                .setPeriod(DepositeTimeType.MONTH, 3)
                .setCapitalizationPeriod(DepositeTimeType.YEAR)
                .calculate();

        assertEquals(1150, depositeRes, delta);
    }

    @Test
    public void cacl3MonthDepositeWithCapitalizationPerMonth() {
        Calculator calc = new Calculator();
        double depositeRes = calc.setStartSum(1000)
                .setPercent(60)
                .setPeriod(DepositeTimeType.MONTH, 3)
                .setCapitalizationPeriod(DepositeTimeType.MONTH)
                .calculate();

        assertEquals(1157.625, depositeRes, delta);
    }
}