package ru.unn.agile.polygon.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTest {

    private final double delta = 0.001;

    private final Point pointA = new Point();
    private final Point pointB = new Point(2, 2.5);
    private final Point pointC = new Point(pointA);

    @Test
    public void canGetPointCoordinates() {
        assertEquals(0, pointA.getX(), delta);
        assertEquals(0, pointA.getY(), delta);

        assertEquals(2, pointB.getX(), delta);
        assertEquals(2.5, pointB.getY(), delta);

        assertEquals(pointA.getX(), pointC.getX(), delta);
        assertEquals(pointA.getY(), pointC.getY(), delta);
    }

    @Test
    public void canGetDistanceToAnotherPoint() {
        assertEquals(pointA.distanceTo(pointB), 3.2015, delta);
    }
}
