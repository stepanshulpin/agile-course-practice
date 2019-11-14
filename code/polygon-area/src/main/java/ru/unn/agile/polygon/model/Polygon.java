package ru.unn.agile.polygon.model;

import java.util.List;

public class Polygon {
    private final Point[] vertices;
    private final int size;
    private final double area;

    public Polygon(Point... points) {
        if (points.length < 3)
            throw new IllegalArgumentException("A polygon must have at least three vertices");

        this.vertices = points;
        this.size = points.length;
        this.area = this.calculateArea();
    }

    public int getSize() {
        return size;
    }

    public double getArea() {
        return this.area;
    }

    private double calculateArea() {
        double area = 0;

        for (int i = 0; i < this.size - 1; i++) {
            area += Math.abs((vertices[i].getX() + vertices[i+1].getX()) *
                    (vertices[i].getY() - vertices[i+1].getY()));
        }

        area += Math.abs((vertices[this.size - 1].getX() + vertices[0].getX()) *
                (vertices[this.size - 1].getY() - vertices[0].getY()));

        area = area / 2;

        return area;
    }
}
