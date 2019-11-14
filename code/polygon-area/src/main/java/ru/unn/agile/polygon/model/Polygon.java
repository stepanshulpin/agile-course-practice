package ru.unn.agile.polygon.model;

import java.util.List;

public class Polygon {
    private final Point[] points = new Point[3];

    public Polygon(Point pointA, Point pointB, Point pointC) {
        this.points[0] = pointA;
        this.points[1] = pointB;
        this.points[2] = pointC;

    }
}
