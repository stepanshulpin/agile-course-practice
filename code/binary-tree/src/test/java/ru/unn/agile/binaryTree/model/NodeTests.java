package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTests {

    private int     simpleKey  = 0;
    private String  simpleData = "SimpleText";

    private Node rootNode;
    private Node firstChild;
    private Node secondChild;

    private final int firstNodeKey = 1;
    private final int secondNodeKey = 2;

    private String firstChildData  = "FirstSimpleData";
    private String secondChildData = "SecondSimpleData";

    @Before
    public void setUp() {
        rootNode    = new Node(simpleKey, simpleData);
        firstChild  = new Node(firstNodeKey, firstChildData);
        secondChild = new Node(secondNodeKey, secondChildData);
    }

    @Test
    public void canAddChildToChild() {
        rootNode.addChild(firstChild);
        rootNode.addChild(secondChild);

        assertEquals(firstNodeKey, rootNode.getChild().getKey());
    }

    @Test
    public void connectTwoChildIfMiddleDeleted() {
        Node node = new Node(simpleKey, simpleData);
        rootNode.addChild(firstChild);
        rootNode.addChild(secondChild);

        assertTrue(rootNode.removeRecursive(firstNodeKey));

        assertEquals(secondChildData, rootNode.findRecursive(secondNodeKey));
    }

    @Test
    public void canRemoveLastOneWithThreeNodes() {
        Node node = new Node(simpleKey, simpleData);
        rootNode.addChild(firstChild);
        rootNode.addChild(secondChild);

        assertTrue(rootNode.removeRecursive(secondNodeKey));

        assertNull(rootNode.findRecursive(secondNodeKey));
    }

    @Test
    public void canGetHeight() {
        Node node = new Node(simpleKey, simpleData);
        
        assertEquals(1, node.getHeight());
    }
}
