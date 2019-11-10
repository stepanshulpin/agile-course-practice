package redblacktree;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.redblacktree.Model.RedBlackTree;

import static junit.framework.TestCase.*;

public class RedBlackTreeTest {
    private static RedBlackTree tree;

    public RedBlackTreeTest() {
    }

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
    public void emptiedRedBlackTreeIsEmpty() {
        int expected = 42;
        tree.insert(expected);
        tree.remove(expected);

        assertTrue(tree.isEmpty());
    }

    @Test
    public void emptyTreeSizeIsZero() {
        assertEquals(0, tree.getSize());
    }

    @Test
    public void notEmptyTreeSizeIsNotZero() {
        tree.insert(42);
        assertFalse(tree.getSize() == 0);
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
    public void insertCornerCaseMax() {
        tree.insert(Integer.MAX_VALUE);

        assertTrue(tree.find(Integer.MAX_VALUE));
    }

    @Test
    public void insertCornerCaseMin() {
        tree.insert(Integer.MIN_VALUE);

        assertTrue(tree.find(Integer.MIN_VALUE));
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

    @Test
    public void removeReturnsFalseIfNotFound() {
        assertFalse(tree.remove(42));
    }

    @Test
    public void removeReturnsTrueIfFound() {
        int expected = 42;

        tree.insert(expected);

        assertTrue(tree.remove(expected));
    }

    @Test
    public void removeChangesSizeIfFound() {
        int threshold = 88;
        int counter = 0;
        while (counter < threshold) {
            tree.insert(++counter);
        }

        while(counter >= 0) {
            int new_size = tree.getSize() - 1;
            tree.remove(--counter);
            assertEquals(new_size, tree.getSize());
        }
    }

    @Test
    public void removeDoesNotChangeSizeIfNotFound() {
        int threshold = 88;
        int counter = 0;
        while (counter < threshold) {
            tree.insert(++counter);
        }

        int expectedSize = tree.getSize();

        while(counter < threshold * 2) {
            tree.remove(++counter);
            assertEquals(tree.getSize(), expectedSize);
        }
    }
}
