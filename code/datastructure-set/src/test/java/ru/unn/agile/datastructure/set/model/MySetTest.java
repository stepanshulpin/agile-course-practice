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
        Assert.assertEquals(mySet.size(), 0);
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

    @Test
    public void canBeCleared() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.clear();
        Assert.assertTrue(mySet.isEmpty());
    }

    @Test
    public void canConvertToArray() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        mySet.add("second");
        Assert.assertArrayEquals(new String[] {"first", "second"}, mySet.toArray());
    }

    @Test
    public void canNotAddDuplicateElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        mySet.add("first");
        Assert.assertEquals(mySet.size(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void canNotAddNull() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first");
        mySet.add(null);
    }

    @Test
    public void canCheckExistingElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.add("third row");
        mySet.add("fourth row");
        Assert.assertTrue(mySet.contains("third row"));
    }

    @Test
    public void canRemoveElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.add("third row");
        mySet.remove("second row");
        Assert.assertEquals(mySet.size(), 2);
    }

    @Test(expected = NullPointerException.class)
    public void canNotRemoveNullElement() {
        MySet<String> mySet = new MySet<>();
        mySet.add("first row");
        mySet.add("second row");
        mySet.remove(null);
    }

}
