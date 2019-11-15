package ru.unn.agile.salarycalculator.model;

import java.time.LocalDate;

public class SalaryCalculator {
    private static final double NDS = 0.87;
    private static final int WORK_HOURS_PER_DAY = 8;

    private double salary;
    private int workedHoursPerMonth;
    private int vacationDuration;
    private LocalDate vacationStartDate;
    private LocalDate vacationEndDate;

    public SalaryCalculator() {
        this.salary = 0;
        this.workedHoursPerMonth = 0;
        this.vacationDuration = 0;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkedHoursPerMonth() {
        return workedHoursPerMonth;
    }

    public void setWorkedHoursPerMonth(int workedHoursPerMonth) {
        this.workedHoursPerMonth = workedHoursPerMonth;
    }

    public int getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(int vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    public LocalDate getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(LocalDate vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public LocalDate getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(LocalDate vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }
}
