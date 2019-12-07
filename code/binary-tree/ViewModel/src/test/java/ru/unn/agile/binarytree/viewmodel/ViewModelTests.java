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
        assertEquals("", viewModel.findKeyProperty().get());
        assertEquals("", viewModel.addKeyProperty().get());
        assertEquals("", viewModel.removeKeyProperty().get());
        assertEquals("", viewModel.findResultProperty().get());
        assertEquals("", viewModel.addResultProperty().get());
        assertEquals("", viewModel.removeResultProperty().get());
    }
}
