package ru.unn.agile.DijkstraAlgorithm.Model;

import java.util.*;

class DijkstraGraph {

    // mapping of vertex names to Vertex objects, built from a set of Edges
    private final Map<String, Vertex> graph;

    public static class Edge {

        private final String v1, v2;
        private final int dist;

        Edge(final String v1, final String v2, final int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    private static class Vertex { }

    DijkstraGraph(final Edge[] edges) {
        graph = Collections.emptyMap();
    }

    public void calculate(final String startName) { }

    public int getPath(final String endName) {
        return -1;
    }

}
