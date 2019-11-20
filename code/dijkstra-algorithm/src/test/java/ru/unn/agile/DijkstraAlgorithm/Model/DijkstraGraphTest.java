package ru.unn.agile.DijkstraAlgorithm.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraGraphTest {

    @Test
    public void canBuildGraph() {

        final DijkstraGraph.Edge[] edges = {
                new DijkstraGraph.Edge("a", "b", 7)
        };

        boolean isExceptionThrown = false;
        try {
            new DijkstraGraph(edges);
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @Test
    public void canRunDijkstraAlgorithmOnGraph() {

        final DijkstraGraph.Edge[] graph = {
                new DijkstraGraph.Edge("a", "b", 7)
        };
        DijkstraGraph g = new DijkstraGraph(graph);
        final String start = "a";

        boolean isExceptionThrown = false;
        try {
            g.calculate(start);
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @Test
    public void canNotCreateGraphFromNullEdgesArray() {

        DijkstraGraph.Edge[] edges = null;

        boolean isExceptionThrown = false;
        try {
            new DijkstraGraph(edges);
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }

    @Test
    public void canCreateGraphFromEmptyEdgesArray() {

        DijkstraGraph.Edge[] edges = new DijkstraGraph.Edge[0];

        boolean isExceptionThrown = false;
        try {
            new DijkstraGraph(edges);
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @Test
    public void canReturnVertexNumber() {

        DijkstraGraph.Edge[] edges = {
                new DijkstraGraph.Edge("a", "b", 7),
        };
        DijkstraGraph g = new DijkstraGraph(edges);

        assertEquals(2, g.getVertexNumber());
    }

    @Test
    public void canCalculatePathFor2ElementGraph() {

        DijkstraGraph.Edge[] edges = {
                new DijkstraGraph.Edge("a", "b", 7),
        };
        String start = "a";
        String end = "b";

        DijkstraGraph g = new DijkstraGraph(edges);
        g.calculate(start);
        int pathFromAtoB = g.getPath(end);

        assertEquals(7, pathFromAtoB);
    }

    @Test
    public void canNotCalculateGraphForNonExistingVertex() {

        DijkstraGraph.Edge[] edges = {
                new DijkstraGraph.Edge("a", "b", 7),
        };
        String start = "This vertex doesn't exist";

        DijkstraGraph g = new DijkstraGraph(edges);

        boolean isExceptionThrown = false;
        try {
            g.calculate(start);
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }

    @Test
    public void canNotCalculatePath2NonExistingVertex() {

        DijkstraGraph.Edge[] edges = {
                new DijkstraGraph.Edge("a", "b", 7),
        };
        String start = "a";
        String end = "This vertex doesn't exist";

        DijkstraGraph g = new DijkstraGraph(edges);
        g.calculate(start);

        boolean isExceptionThrown = false;
        try {
            g.getPath(end);
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }

}
