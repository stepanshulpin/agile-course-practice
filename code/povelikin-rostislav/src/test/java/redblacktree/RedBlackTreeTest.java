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
}
