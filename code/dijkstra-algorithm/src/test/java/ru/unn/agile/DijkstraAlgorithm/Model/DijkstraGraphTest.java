package ru.unn.agile.DijkstraAlgorithm.Model;

import junit.framework.AssertionFailedError;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DijkstraGraphTest {

    private final List<DijkstraGraph.Edge> nullEdges = null;

    private final List<DijkstraGraph.Edge> emptyEdges = Collections.emptyList();

    private final List<DijkstraGraph.Edge> edgeAB =
            Collections.singletonList(new DijkstraGraph.Edge("a", "b", 7));

    private final List<DijkstraGraph.Edge> edgesABCD = Arrays.asList(
            new DijkstraGraph.Edge("a", "b", 4),
            new DijkstraGraph.Edge("с", "d", 5)
    );

    private final List<DijkstraGraph.Edge> edges1 = Arrays.asList(
                 new DijkstraGraph.Edge("a", "b", 4),
                new DijkstraGraph.Edge("a", "c", 5),
                new DijkstraGraph.Edge("a", "d", 6),
                new DijkstraGraph.Edge("b", "e", 8),
                new DijkstraGraph.Edge("c", "e", 7),
                new DijkstraGraph.Edge("d", "e", 4)
    );

    private final List<DijkstraGraph.Edge> edges2 = Arrays.asList(
            new DijkstraGraph.Edge("a", "b", 4),
            new DijkstraGraph.Edge("a", "c", 5),
            new DijkstraGraph.Edge("a", "d", 6),
            new DijkstraGraph.Edge("b", "c", 2),
            new DijkstraGraph.Edge("d", "c", 1),
            new DijkstraGraph.Edge("c", "e", 3),
            new DijkstraGraph.Edge("e", "f", 11),
            new DijkstraGraph.Edge("e", "g", 5),
            new DijkstraGraph.Edge("e", "h", 6),
            new DijkstraGraph.Edge("f", "k", 1),
            new DijkstraGraph.Edge("g", "k", 7),
            new DijkstraGraph.Edge("h", "k", 10)
    );

    private final List<DijkstraGraph.Edge> edgeAbNegative =
            Collections.singletonList(new DijkstraGraph.Edge("a", "b", -7));


    @Test
    public void canBuildGraph() {
        assertNotThrows(() -> new DijkstraGraph(edgeAB));
    }

    @Test
    public void canNotBuildGraphForWithNegativeWeightEdge() {
        assertThrows(() -> new DijkstraGraph(edgeAbNegative), RuntimeException.class);
    }

    @Test
    public void canRunDijkstraAlgorithmOnGraph() {

        DijkstraGraph g = new DijkstraGraph(edgeAB);
        final String start = "a";

        assertNotThrows(() -> g.calculate(start));
    }

    @Test
    public void canNotCreateGraphFromNullEdgesArray() {
        assertThrows(() -> new DijkstraGraph(nullEdges), RuntimeException.class);
    }

    @Test
    public void canNotCreateGraphFromEmptyEdgesArray() {
        assertThrows(() -> new DijkstraGraph(emptyEdges), RuntimeException.class);
    }

    @Test
    public void canReturnVertexNumber() {
        DijkstraGraph g = new DijkstraGraph(edgeAB);
        assertEquals(2, g.getVertexNumber());
    }

    @Test
    public void canNotCalculateGraphForNonExistingVertex() {

        DijkstraGraph g = new DijkstraGraph(edgeAB);
        String start = "This vertex doesn't exist";

        Runnable calculateGraphSnippet = () ->  g.calculate(start);
        assertThrows(calculateGraphSnippet, RuntimeException.class);
    }

    @Test
    public void canCalculatePathFor2ElementGraph() {

        DijkstraGraph g = new DijkstraGraph(edgeAB);
        String start = "a";
        String end = "b";

        g.calculate(start);
        int pathFromAtoB = g.getPath(end);

        assertEquals(7, pathFromAtoB);
    }

    @Test
    public void canCalculatePathForGraph() {

        String start = "a";
        String end = "e";

        DijkstraGraph g = new DijkstraGraph(edges1);
        g.calculate(start);
        int pathFromAtoE = g.getPath(end);

        assertEquals(10, pathFromAtoE);
    }

    @Test
    public void canCalculatePathForBiggerGraph() {

        DijkstraGraph g = new DijkstraGraph(edges2);
        String start = "a";
        String end = "k";

        g.calculate(start);
        int pathFromAtoK = g.getPath(end);

        assertEquals(20, pathFromAtoK);
    }

    @Test
    public void canNotCalculatePath2NonExistingVertex() {

        DijkstraGraph g = new DijkstraGraph(edgeAB);
        String start = "a";
        String end = "This vertex doesn't exist";

        g.calculate(start);
        assertThrows(() -> g.getPath(end), RuntimeException.class);
    }

    @Test
    public void canCalculatePathToStartPoint() {

        DijkstraGraph g = new DijkstraGraph(edgeAB);
        String start = "a";
        g.calculate(start);

        assertEquals(0, g.getPath(start));
    }

    @Test
    public void canNotCalculatePathToUnreachablePoint() {

        DijkstraGraph g = new DijkstraGraph(edgesABCD);
        String start = "a";
        String end = "d";

        g.calculate(start);
        int pathFromAtoD = g.getPath(end);

        assertEquals(Integer.MAX_VALUE, pathFromAtoD);
    }

    // since JUnit4 doesn't have assertThrows  for now we can use self-developed stub
    private <T extends Throwable> void assertThrows(Runnable codeSnippet, Class<T> expectedType) {
        try {
            codeSnippet.run();
        } catch (Throwable actualException) {
            if(!expectedType.isInstance(actualException)) {
                throw new AssertionFailedError("Expected exception is not caught");
            }
        }
    }

    private <T extends Throwable> void assertNotThrows(Runnable codeSnippet) {
        try {
            codeSnippet.run();
        } catch (Throwable e) {
            throw new AssertionFailedError("Some exception is caught");
        }
    }

}
