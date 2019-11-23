package ru.unn.agile.converter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LengthConverterViewModelTests {

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
    public void canSetEmptyStringInTextFieldsByDefault() {
        assertEquals("", viewModel.getInput().get());
        assertEquals("", viewModel.getOutput().get());
    }

    @Test
    public void canSetConvertButtonDisabledByDefault() {
        assertTrue(viewModel.isConvertButtonDisabled().get());
    }


}
