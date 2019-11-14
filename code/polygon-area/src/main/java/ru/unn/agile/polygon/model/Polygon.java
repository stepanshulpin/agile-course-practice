package ru.unn.agile.polygon.model;

import java.util.List;

public class Polygon {
    private final Point[] vertices;

    public Polygon(Point... points) {
        if (points.length < 3)
            throw new IllegalArgumentException("A polygon must have at least three vertices");

        this.vertices = points;
    }

    public int getSize() {
        return vertices.length;
    }
}
