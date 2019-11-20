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
    private static class Vertex implements Comparable<Vertex> {
        final String name;
        int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        Vertex previous = null;
        final Map<Vertex, Integer> neighbours = new HashMap<>();

        Vertex(String name) {
            this.name = name;
        }

        public int compareTo(Vertex other) {
            if (dist == other.dist)
                return name.compareTo(other.name);

            return Integer.compare(dist, other.dist);
        }

    }

    /**
     * Builds a graph from a set of edges
     */
    public DijkstraGraph(List<Edge> edges) {
        validateEdges(edges);

        graph = new HashMap<>(edges.size());

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
     * Validates set of edges
     */
    private void validateEdges(List<Edge> edges) {
        if (edges == null || edges.isEmpty()) {
            throw new RuntimeException("Array of edges can not be null or empty");
        }
        for (Edge e : edges) {
            if (e.dist <= 0) {
                throw new RuntimeException("Edge's weight can not be negative or equal to 0");
            }
            if (e.v1.equals(e.v2)) {
                throw new RuntimeException("Edge's can not link vertex to itself");
            }
        }
    }

    /**
     * Calculates distances to all vertices relatively to specified source
     */
    public void calculate(String startName) {
        if (!graph.containsKey(startName)) {
            throw new RuntimeException("Graph doesn't contain start vertex \"" + startName + "\"");
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /**
     * Implementation of dijkstra's algorithm using a binary heap.
     */
    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE)
                break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /**
     * Returns distance to specified vertex relatively to source one
     */
    public int getPath(final String endName) {
        if (!graph.containsKey(endName)) {
            throw new RuntimeException("Graph doesn't contain start vertex \"" + endName + "\"");
        }
        return graph.get(endName).dist;
    }

    /**
     * Returns a quantity of vertices in the graph
     */
    public int getVertexNumber() {
        return graph.size();
    }
}
