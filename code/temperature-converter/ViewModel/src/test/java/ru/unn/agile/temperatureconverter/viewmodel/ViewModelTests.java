package ru.unn.agile.temperatureconverter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.temperatureconverter.viewmodel.ViewModel.ListOfTemperatures;

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
    public void canSetDefaultValues() {
        assertEquals("", viewModel.getFromTemperature());
        assertEquals("", viewModel.getResultTemperature());
        assertEquals(ListOfTemperatures.CELSIUS, viewModel.getFrom());
        assertEquals(ListOfTemperatures.CELSIUS, viewModel.getTo());
        assertEquals("", viewModel.getResultTemperature());
        assertEquals(false, viewModel.isConvertButtonEnabled());
        assertEquals(false, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void convertButtonIsDisabledInitially() {
        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void convertButtonIsDisabledWhenFormatIsBad() {
        viewModel.setFromTemperature("trash");
        viewModel.processInput();
        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void statusTextWhenFormatIsBad() {
        viewModel.setFromTemperature("trash");
        viewModel.processInput();
        assertEquals("Error. Please enter correct temperature", viewModel.getStatusText());
    }

    @Test
    public void convertButtonIsDisabledWithEmptyInput() {
        viewModel.processInput();

        assertFalse(viewModel.isConvertButtonEnabled());
    }

    @Test
    public void canSetCelsiusFrom() {
        viewModel.setFrom(ListOfTemperatures.CELSIUS);
        assertEquals(ListOfTemperatures.CELSIUS, viewModel.getFrom());
    }

    @Test
    public void canSetNewtonTo() {
        viewModel.setTo(ListOfTemperatures.NEWTON);
        assertEquals(ListOfTemperatures.NEWTON, viewModel.getTo());
    }

    @Test
    public void celsiusIsDefaultTemperatureFrom() {
        assertEquals(ListOfTemperatures.CELSIUS, viewModel.getFrom());
    }

    @Test
    public void celsiusIsDefaultTemperatureTo() {
        assertEquals(ListOfTemperatures.CELSIUS, viewModel.getTo());
    }

    @Test
    public void convertFromCelsiusToCelsiusHasCorrectResult() {
        viewModel.setFromTemperature("0.0");
        viewModel.calculate();

        assertEquals("0.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertFromCelsiusToNewtonHasCorrectResult() {
        viewModel.setFromTemperature("33.0");
        viewModel.setTo(ListOfTemperatures.NEWTON);
        viewModel.calculate();

        assertEquals("10.89", viewModel.getResultTemperature());
    }

    @Test
    public void convertFromCelsiusToNewtonHasIncorrectResult() {
        viewModel.setFromTemperature("-300.0");
        viewModel.setTo(ListOfTemperatures.NEWTON);
        viewModel.calculate();

        assertEquals("The temperature is less than absolute zero!", viewModel.getStatusText());
    }

}
