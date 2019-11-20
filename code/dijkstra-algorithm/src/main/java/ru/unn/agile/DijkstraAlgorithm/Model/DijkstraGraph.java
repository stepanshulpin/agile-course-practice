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

    /**
     * One vertex of the graph, complete with mappings to neighbouring vertices
     */
    private static class Vertex {
        final String name;
        int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        Vertex previous = null;
        final Map<Vertex, Integer> neighbours = new HashMap<>();

        Vertex(String name) {
            this.name = name;
        }

    }

    /**
     * Builds a graph from a set of edges
     */
    public DijkstraGraph(Edge[] edges) {
        if (edges == null) {
            throw new RuntimeException("Array of edges is null");
        }
        graph = new HashMap<>(edges.length);

        //one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
            if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
        }
    }

    /**
     * Calculates distances to all vertices relatively to specified source
     */
    public void calculate(String startName) { }

    /**
     * Returns distance to specified vertex relatively to source one
     */
    public int getPath(final String endName) {
        return -1;
    }

    /**
     * Returns a quantity of vertices in the graph
     */
    public int getVertexNumber() {
        return graph.size();
    }
}
