package ru.unn.agile.polygon.model;

import java.util.List;

public class Polygon {
    private final Point[] vertices;

    public Polygon(Point... points) throws Exception {
        if (points.length < 3) throw new Exception("A polygon must have at least three vertices");
        this.vertices = points;
    }
}
