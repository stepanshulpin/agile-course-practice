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

    @Test
    public void canGetRealSize() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        Assert.assertEquals(mySet.size(), 2);
    }

    @Test
    public void canCheckEmpty() {
        MySet mySet = new MySet();
        Assert.assertTrue(mySet.isEmpty());
    }

}
