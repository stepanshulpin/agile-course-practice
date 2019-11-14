package ru.unn.agile.polygon.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
            Polygon square = new Polygon(pointA, pointB, pointC, pointD);
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }

    @Test(expected = Exception.class)
    public void cantCreatePolygonWithLessThanThreePoints() throws Exception {
        Point pointA = new Point();
        Point pointB = new Point(0, 2);

        Polygon pol1 = new Polygon();
        Polygon pol2 = new Polygon(pointA);
        Polygon pol3 = new Polygon(pointA, pointB);
    }
}
