package ru.unn.agile.binarysearch.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void canSetDefaultArrayValue() {

        assertEquals("", viewModel.getArrayInputProperty());
    }

    @Test
    public void canSetDefaultElementValue() {

        assertEquals("", viewModel.getElementInputProperty());
    }

    @Test
    public void canSetDefaultStatus() {

        assertEquals("", viewModel.getStatusProperty());
    }

    @Test
    public void canSetDefaultResult() {

        assertEquals("", viewModel.getResultProperty());
    }
}
