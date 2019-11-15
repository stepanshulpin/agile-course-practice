package ru.unn.agile.salarycalculator.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SalaryCalculatorTest {
    private final double delta = 0.001;

    @Test
    public void canSetSalary() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setSalary(1000);
        assertEquals(1000, salaryCalculator.getSalary(), delta);
    }

}
