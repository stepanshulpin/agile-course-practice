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

    public double getArea() {
        double area = 0;

        for (int i = 0; i < vertices.length - 1; i++) {
            area += Math.abs((vertices[i].getX() + vertices[i+1].getX()) *
                    (vertices[i].getY() - vertices[i+1].getY()));
        }

        area += Math.abs((vertices[vertices.length - 1].getX() + vertices[0].getX()) *
                (vertices[vertices.length - 1].getY() - vertices[0].getY()));

        area = area / 2;

        return area;
    }
}
