package ru.unn.agile.DijkstraAlgorithm.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraGraphTest {

    @Test
    public void canBuildGraph() {

        final DijkstraGraph.Edge[] graph = {
                new DijkstraGraph.Edge("a", "b", 7)
        };

        boolean isExceptionThrown = false;
        try {
            new DijkstraGraph(graph);
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
    public void canCalculatePathStub() {

        DijkstraGraph.Edge[] graph = {
                new DijkstraGraph.Edge("a", "b", 7),
        };
        String start = "a";
        String end = "e";

        DijkstraGraph g = new DijkstraGraph(graph);
        g.calculate(start);
        int pathFromAtoE = g.getPath(end);

        assertEquals(pathFromAtoE, -1);
    }

}
