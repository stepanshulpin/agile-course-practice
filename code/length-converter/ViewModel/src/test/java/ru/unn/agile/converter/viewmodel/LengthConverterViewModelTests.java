package ru.unn.agile.converter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.converter.model.LengthType;

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

    @Test
    public void canSetListFromTypesByDefault() {
        assertEquals(LengthType.METER, viewModel.getFromType().get());
    }

    @Test
    public void canSetListToTypesByDefault() {
        assertEquals(LengthType.CENTIMETER, viewModel.getToType().get());
    }

    @Test
    public void canSetConvertButtonEnabledAfterInput() {
        viewModel.getInput().set("1");

        assertFalse(viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void canSetConvertButtonDisabledAfterClearInput() {
        viewModel.getInput().set("1");
        viewModel.getInput().set("");

        assertTrue(viewModel.isConvertButtonDisabled().get());
    }

}
