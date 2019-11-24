package ru.unn.agile.DijkstraAlgorithm.Model;

import junit.framework.AssertionFailedError;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DijkstraGraphTest {

    private static final List<DijkstraGraph.Edge> EMPTY_EDGES = Collections.emptyList();

    private static final List<DijkstraGraph.Edge> EDGE_AB =
            Collections.singletonList(new DijkstraGraph.Edge("a", "b", 7));
    private static final String EDGE_AB_A_TO_B_PATH = "a(0) -> b(7)";
    private static final String EDGE_AB_A_TO_A_PATH = "a(0)";

    private static final List<DijkstraGraph.Edge> EDGES_ABCD = Arrays.asList(
            new DijkstraGraph.Edge("a", "b", 4),
            new DijkstraGraph.Edge("с", "d", 5)
    );
    private static final String CAN_NOT_REACH_D_VERTEX = "Can not reach d vertex";

    private static final List<DijkstraGraph.Edge> EDGES_1 = Arrays.asList(
            new DijkstraGraph.Edge("a", "b", 4),
            new DijkstraGraph.Edge("a", "c", 5),
            new DijkstraGraph.Edge("a", "d", 6),
            new DijkstraGraph.Edge("b", "e", 8),
            new DijkstraGraph.Edge("c", "e", 7),
            new DijkstraGraph.Edge("d", "e", 4)
    );
    private static final String EDGES_1_A_TO_E_PATH = "a(0) -> d(6) -> e(10)";

    private static final List<DijkstraGraph.Edge> EDGES_2 = Arrays.asList(
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
    private static final String EDGES2_A_TO_K_PATH = "a(0) -> c(5) -> e(8) -> g(13) -> k(20)";

    private static final List<DijkstraGraph.Edge> EDGE_AB_NEGATIVE =
            Collections.singletonList(new DijkstraGraph.Edge("a", "b", -7));

    @Test
    public void canBuildGraph() {
        assertNotThrows(() -> new DijkstraGraph(EDGE_AB));
    }

    @Test
    public void canNotBuildGraphWithNegativeWeightEdge() {
        assertThrows(() -> new DijkstraGraph(EDGE_AB_NEGATIVE), RuntimeException.class);
    }

    @Test
    public void canRunDijkstraAlgorithmOnGraph() {

        DijkstraGraph g = new DijkstraGraph(EDGE_AB);
        final String start = "a";

        assertNotThrows(() -> g.calculate(start));
    }

    @Test
    public void canNotCreateGraphFromNullEdgesList() {
        assertThrows(() -> new DijkstraGraph(null), RuntimeException.class);
    }

    @Test
    public void canNotCreateGraphFromEmptyEdgesArray() {
        assertThrows(() -> new DijkstraGraph(EMPTY_EDGES), RuntimeException.class);
    }

    @Test
    public void canReturnVertexNumber() {
        DijkstraGraph g = new DijkstraGraph(EDGE_AB);
        assertEquals(2, g.getVertexNumber());
    }

    @Test
    public void canNotCalculateGraphForNonExistingVertex() {

        DijkstraGraph g = new DijkstraGraph(EDGE_AB);
        String start = "This vertex doesn't exist";

        Runnable calculateGraphSnippet = () ->  g.calculate(start);
        assertThrows(calculateGraphSnippet, RuntimeException.class);
    }

    @Test
    public void canCalculatePathFor2ElementGraph() {

        DijkstraGraph g = new DijkstraGraph(EDGE_AB);
        String start = "a";
        String end = "b";

        g.calculate(start);
        String pathFromAtoB = g.getPath(end);

        assertEquals(EDGE_AB_A_TO_B_PATH, pathFromAtoB);
    }

    @Test
    public void canCalculatePathForGraph() {

        String start = "a";
        String end = "e";

        DijkstraGraph g = new DijkstraGraph(EDGES_1);
        g.calculate(start);
        String pathFromAtoE = g.getPath(end);

        assertEquals(EDGES_1_A_TO_E_PATH, pathFromAtoE);
    }

    @Test
    public void canCalculatePathForBiggerGraph() {

        DijkstraGraph g = new DijkstraGraph(EDGES_2);
        String start = "a";
        String end = "k";

        g.calculate(start);
        String pathFromAtoK = g.getPath(end);

        assertEquals(EDGES2_A_TO_K_PATH, pathFromAtoK);
    }

    @Test
    public void canNotCalculatePath2NonExistingVertex() {

        DijkstraGraph g = new DijkstraGraph(EDGE_AB);
        String start = "a";
        String end = "This vertex doesn't exist";

        g.calculate(start);
        assertThrows(() -> g.getPath(end), RuntimeException.class);
    }

    @Test
    public void canCalculatePathToStartPoint() {

        DijkstraGraph g = new DijkstraGraph(EDGE_AB);
        String start = "a";
        g.calculate(start);

        assertEquals(EDGE_AB_A_TO_A_PATH, g.getPath(start));
    }

    @Test
    public void canNotCalculatePathToUnreachablePoint() {

        DijkstraGraph g = new DijkstraGraph(EDGES_ABCD);
        String start = "a";
        String end = "d";

        g.calculate(start);
        String pathFromAtoD = g.getPath(end);

        assertEquals(CAN_NOT_REACH_D_VERTEX, pathFromAtoD);
    }

    // since JUnit4 doesn't have assertThrows  for now we can use self-developed stub
    private <T extends Throwable> void assertThrows(final Runnable codeSnippet,
                                                    final Class<T> expectedType) {
        try {
            codeSnippet.run();
        } catch (Throwable actualException) {
            if (!expectedType.isInstance(actualException)) {
                throw new AssertionFailedError("Expected exception is not caught");
            }
        }
    }

    private <T extends Throwable> void assertNotThrows(final Runnable codeSnippet) {
        try {
            codeSnippet.run();
        } catch (Throwable e) {
            throw new AssertionFailedError("Some exception is caught");
        }
    }

}
