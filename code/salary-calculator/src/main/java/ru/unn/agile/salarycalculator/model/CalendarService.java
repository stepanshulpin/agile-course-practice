package ru.unn.agile.salarycalculator.model;

import java.time.LocalDate;

public class CalendarService {
    private int vacationDuration;
    private LocalDate vacationStartDate;
    private LocalDate month;

    public CalendarService() {
        this.vacationDuration = 0;
        this.vacationStartDate = LocalDate.of(2010, 1, 1);
        this.month = LocalDate.now();
    }

    public int getVacationDuration() {
        return vacationDuration;
    }

    public CalendarService setVacationDuration(int vacationDuration) {
        if (vacationDuration < 0) {
            throw new NumberFormatException("Wrong duration");
        }
        this.vacationDuration = vacationDuration;
        return this;
    }

    public LocalDate getVacationStartDate() {
        return vacationStartDate;
    }

    public CalendarService setVacationStartDate(LocalDate vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
        return this;
    }

    public LocalDate getMonth() {
        return month;
    }

    public CalendarService setMonth(LocalDate month) {
        this.month = month;
        return this;
    }

}
