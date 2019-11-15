package ru.unn.agile.salarycalculator.model;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubtractHolidaysTest {
    @Test
    public void checkNotDayOff() {
        SubtractHolidays checkPeriod = new SubtractHolidays();
        checkPeriod.setMonth(LocalDate.of(2018, Month.SEPTEMBER, 1));
        assertTrue(checkPeriod.isNotDayOff(3));
    }

    @Test
    public void checkDayOff() {
        SubtractHolidays checkPeriod = new SubtractHolidays();
        checkPeriod.setMonth(LocalDate.of(2018, Month.SEPTEMBER, 1));
        assertFalse(checkPeriod.isNotDayOff(22));
    }

    @Test
    public void checkDayForSubtractionWithoutVacation() {
        SubtractHolidays checkPeriod = new SubtractHolidays();
        checkPeriod.setMonth(LocalDate.of(2018, Month.AUGUST, 1));
        assertEquals(0, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkDayForSubtractionWithSameVacationMonth() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.AUGUST, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.AUGUST, 4));
        checkPeriod.setVacationDuration(14);

        assertEquals(10, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkDayForSubtractionWithDifferentVacationMonth() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.AUGUST, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.JULY, 28));
        checkPeriod.setVacationDuration(14);

        assertEquals(8, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkSubtractionDayWithStartInCountMonthButEndInAnother() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.AUGUST, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.AUGUST, 25));
        checkPeriod.setVacationDuration(14);

        assertEquals(5, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkSubtractionDayWithVacationInMiddleOfMonth() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.SEPTEMBER, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.SEPTEMBER, 10));
        checkPeriod.setVacationDuration(14);

        assertEquals(10, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkSubtractionDayWithVacationEndInMiddleOfAnotherMonth() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.NOVEMBER, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.OCTOBER, 28));
        checkPeriod.setVacationDuration(14);

        assertEquals(7, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkSubtractionDayWithVacationStartInMiddleOfCountMonth() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.MARCH, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.MARCH, 21));
        checkPeriod.setVacationDuration(14);

        assertEquals(8, checkPeriod.getHolidaysInVacation());
    }

    @Test
    public void checkSubtractionDayWhenAllMonthInVacation() {
        SubtractHolidays checkPeriod = new SubtractHolidays();

        checkPeriod.setMonth(LocalDate.of(2018, Month.JULY, 1));
        checkPeriod.setVacationStartDate(LocalDate.of(2018, Month.JUNE, 19));
        checkPeriod.setVacationDuration(50);

        assertEquals(22, checkPeriod.getHolidaysInVacation());
    }
}
