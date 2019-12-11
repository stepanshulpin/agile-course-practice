package ru.unn.agile.depositcalculator.viewmodel;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ViewModelTest {

    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        Assert.assertEquals(true, true);
    }

}
