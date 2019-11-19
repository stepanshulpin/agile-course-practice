package ru.unn.agile.polygon.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    private double delta = 0.0001;
    Point p1 = new Point(0, 0);
    Point p2 = new Point(1, 0);
    Point p3 = new Point(1, 1);
    Point p4 = new Point(0, 1);
    Point p5 = new Point(5, 1);

    @Test
    public void canGetLinePoints() {
        Line line = new Line(p1, p2);

        assertEquals(p1, line.getPoint1());
        assertEquals(p2, line.getPoint2());
    }


    @Test
    public void canGetLineCoordinates() {
        Line line = new Line(p1, p2);

        assertEquals(p2.getX()-p1.getX(), line.getX(), delta);
        assertEquals(p2.getY()-p1.getY(), line.getY(), delta);

        assertEquals(p1.getX(), line.getXPoint1(), delta);
        assertEquals(p1.getY(), line.getYPoint1(), delta);

        assertEquals(p2.getX(), line.getXPoint2(), delta);
        assertEquals(p2.getY(), line.getYPoint2(), delta);
    }

    @Test
    public void DoesIntersectedLinesIntercept() {
        Line line1 = new Line(p1, p3);
        Line line2 = new Line(p2, p4);

        assertTrue(line1.intersectsLine(line2));
        assertTrue(line2.intersectsLine(line1));
    }

    @Test
    public void AreLinesIntecptingEachOther() {
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p2, p3);
        Line line3 = new Line(p3, p5);

        assertFalse(line1.intersectsLine(line2));
        assertFalse(line1.intersectsLine(line3));
        assertFalse(line2.intersectsLine(line3));
    }
}
