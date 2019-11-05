package ru.unn.agile.datastructure.set.model;

import org.junit.Assert;
import org.junit.Test;

public class MySetTest {
    @Test
    public void canInitDefaultConstructor() {
        MySet mySet = new MySet();
        Assert.assertNotNull(mySet);
    }

    @Test
    public void canGetSize() {
        MySet mySet = new MySet();
        Assert.assertEquals(mySet.size(),  0);
    }

    @Test
    public void canAddElement() {
        MySet<String> mySet = new MySet<>();
        Assert.assertTrue(mySet.add("test"));
    }
}
