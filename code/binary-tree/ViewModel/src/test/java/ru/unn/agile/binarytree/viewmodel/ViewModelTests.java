package ru.unn.agile.binarytree.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTests {
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
        assertEquals("", viewModel.addKeyProperty().get());
        assertEquals("", viewModel.addValueProperty().get());
        assertEquals("", viewModel.addResultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.addStatusProperty().get());
    }
}
