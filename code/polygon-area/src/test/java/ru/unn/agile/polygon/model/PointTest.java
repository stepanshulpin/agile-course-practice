package ru.unn.agile.polygon.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void canCreatePointWithoutInitialValues() {
        Point point = new Point();
        assertEquals(new Point(0, 0), point);
    }
}
