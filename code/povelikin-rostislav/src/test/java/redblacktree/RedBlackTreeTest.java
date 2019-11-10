package redblacktree;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.redblacktree.Model.RedBlackTree;

import static junit.framework.TestCase.*;

public class RedBlackTreeTest {
    private static RedBlackTree tree;

    @Before
    public void setUp() {
        tree = new RedBlackTree();
    }

    @Test
    public void defaultConstructedIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    public void insertionChangesEmptiness() {
        tree.insert(8);

        assertFalse(tree.isEmpty());
    }

    @Test
    public void insertionChangesSize() {
        int threshold = 8;
        int counter = 0;
        while (counter < threshold) {
            ++counter;
            final int newSize = tree.getSize() + 1;
            tree.insert(counter);
            assertEquals(tree.getSize(), newSize);
        }
    }

    @Test
    public void canFindInserted() {
        int expected = 42;
        tree.insert(expected);

        assertTrue(tree.find(expected));
    }

    @Test
    public void canFindEachInserted() {
        int threshold = 88;
        int counter = 0;
        while (counter < threshold) {
            ++counter;
            tree.insert(counter);
            assertTrue(tree.find(counter));
        }
    }

    @Test
    public void cannotFindNotInserted() {
        int threshold = 88;
        int counter = 0;
        while (counter < threshold) {
            assertFalse(tree.find(++counter));
        }
    }
}
