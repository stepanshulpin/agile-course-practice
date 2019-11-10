package redblacktree;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.redblacktree.Model.RedBlackTree;

import static junit.framework.TestCase.assertTrue;

public class RedBlackTreeTest {
    private static RedBlackTree myTree;

    @Before
    public void setUp() {
        myTree = new RedBlackTree();
    }

    @Test
    public void canConstructDefaultAndEmpty() {
        assertTrue(myTree.isEmpty());
    }
}
