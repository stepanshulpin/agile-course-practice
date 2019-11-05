package ru.unn.agile.datastructure.set.model;

import org.junit.Assert;
import org.junit.Test;

public class MySetTest {
    @Test
    public void canInitDefaultConstructor() {
        MySet mySet = new MySet();
        Assert.assertNotNull(mySet);
    }
}
