package ru.unn.agile.binaryTree.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTests {

    private int     simpleKey  = 42;
    private String  simpleData = "SimpleText";

    @Test
    public void canAddChildToChild() {
        Node node = new Node(simpleKey, simpleData);
        final int firstNodeKey = 1;
        Node firstChild  = new Node(firstNodeKey, "FirstSimpleData");
        Node secondChild = new Node(2, "SecondSimpleData");

        node.addChild(firstChild);
        node.addChild(secondChild);

        assertEquals(firstNodeKey, node.getChild().getKey());
    }
}
