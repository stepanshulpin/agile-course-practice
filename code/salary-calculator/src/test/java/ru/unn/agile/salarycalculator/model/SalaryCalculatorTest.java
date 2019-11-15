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

    @Test (expected = NumberFormatException.class)
    public void canNotSetNegativeSalary() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setSalary(-1);
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetSalaryMoreThanMaxSalary() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setSalary(1000000000);
    }

    @Test
    public void canSetWorkedHoursPerMonth() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setWorkedHoursPerMonth(100);
        assertEquals(100, salaryCalculator.getWorkedHoursPerMonth());
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetNegativeWorkedHoursPerMonth() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setWorkedHoursPerMonth(-1);
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetHoursPerMonthMoreThanMaxValue() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setWorkedHoursPerMonth(401);
    }

    @Test
    public void canSetVacationDuration() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setVacationDuration(10);
        assertEquals(10, salaryCalculator.getVacationDuration());
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetNegativeVacationDuration() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        salaryCalculator.setVacationDuration(-1);
    }
}
