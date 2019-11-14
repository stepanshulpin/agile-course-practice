package ru.unn.agile.polygon.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    private final double delta = 0.001;

    @Test
    public void canGetXValueFromPointZero() {
        Point pointA = new Point();
        Point pointB = new Point(0, 0);
        assertEquals(0, pointA.getX(), delta);
        assertEquals(0, pointB.getX(), delta);
    }

    @Test
    public void canGetYValueFromPointZero() {
        Point pointA = new Point();
        Point pointB = new Point(0, 0);
        assertEquals(0, pointA.getY(), delta);
        assertEquals(0, pointB.getY(), delta);
    }
}
}
