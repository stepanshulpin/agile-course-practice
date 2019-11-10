package redblacktree;

import org.junit.Test;
import ru.unn.agile.redblacktree.Model.RedBlackTree;

import static junit.framework.TestCase.assertTrue;

public class RedBlackTreeTest {
    @Test
    public void canConstructDefaultAndEmpty() {
        RedBlackTree tree = new RedBlackTree();

        assertTrue(tree.isEmpty());
    }
}
