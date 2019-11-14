package ru.unn.agile.polygon.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    private final double delta = 0.001;

    @Test
    public void canGetPointСoordinates() {
        Point pointA = new Point();
        Point pointB = new Point(2, 2.5);
        Point pointC = new Point(pointA);

        assertEquals(0, pointA.getX(), delta);
        assertEquals(0, pointA.getY(), delta);

        assertEquals(2, pointB.getX(), delta);
        assertEquals(2.5, pointB.getY(), delta);

        assertEquals(pointA.getX(), pointC.getX(), delta);
        assertEquals(pointA.getY(), pointC.getY(), delta);
    }
}
