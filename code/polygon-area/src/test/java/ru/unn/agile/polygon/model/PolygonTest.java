package ru.unn.agile.polygon.model;

import org.junit.Test;

import static org.junit.Assert.fail;

public class PolygonTest {
    @Test
    public void canCreateTriangle() {
        Point pointA = new Point();
        Point pointB = new Point(0, 2);
        Point pointC = new Point(2, 0);

        try{
            Polygon triangle = new Polygon(pointA, pointB, pointC);
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }

    @Test
    public void canCreateSquare() {
        Point pointA = new Point();
        Point pointB = new Point(0, 2);
        Point pointC = new Point(2, 2);
        Point pointD = new Point(2, 0);

        try{
            Polygon triangle = new Polygon(pointA, pointB, pointC, pointD);
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }
}
