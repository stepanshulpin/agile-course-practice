package ru.unn.agile.salarycalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;

public class CalendarServiceTest {

    @Test
    public void canSetMonth() {
        CalendarService service = new CalendarService();
        service.setMonth(LocalDate.now());
        assertEquals(LocalDate.now(), service.getMonth());
    }

    @Test
    public void canSetVacationDuration() {
        CalendarService service = new CalendarService();
        service.setVacationDuration(10);
        assertEquals(10, service.getVacationDuration());
    }

    @Test (expected = NumberFormatException.class)
    public void canNotSetNegativeVacationDuration() {
        CalendarService service = new CalendarService();
        service.setVacationDuration(-1);
    }
}
