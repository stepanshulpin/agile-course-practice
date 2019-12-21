package ru.unn.agile.temperatureconverter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.temperatureconverter.viewmodel.ViewModel.ListOfTemperatures;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;
    private final double delta = 0.001;

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
        assertFalse(viewModel.isConvertButtonEnabled());
        assertFalse(viewModel.isErrorMessageDisplayed());
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
    @Test
    public void convertFromCelsius0ToFahrenheit32() {
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.FAHRENHEIT);
        viewModel.calculate();

        assertEquals("32.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertFromCelsius5ToFahrenheit41() {
        viewModel.setFromTemperature("5.0");
        viewModel.setTo(ListOfTemperatures.FAHRENHEIT);
        viewModel.calculate();

        assertEquals("41.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertCelsius0ToKelvin273() {
        viewModel.setFrom(ListOfTemperatures.CELSIUS);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.KELVIN);
        viewModel.calculate();

        assertEquals("273.15", viewModel.getResultTemperature());
    }
    @Test
    public void convertFahrenheit41ToCelsius5() {
        viewModel.setFrom(ListOfTemperatures.FAHRENHEIT);
        viewModel.setFromTemperature("41.0");
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.calculate();

        assertEquals("5.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertFahrenheit10ToKelvin260() {
        viewModel.setFrom(ListOfTemperatures.FAHRENHEIT);
        viewModel.setFromTemperature("10.0");
        viewModel.setTo(ListOfTemperatures.KELVIN);
        viewModel.calculate();

        assertEquals(260.927, viewModel.getDoubleResult(), delta);
    }

    @Test
    public void convertFahrenheit0ToKelvin255() {
        viewModel.setFrom(ListOfTemperatures.FAHRENHEIT);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.KELVIN);
        viewModel.calculate();

        assertEquals(255.372, viewModel.getDoubleResult(), delta);
    }

    @Test
    public void convertFahrenheit32ToNewton0() {
        viewModel.setFrom(ListOfTemperatures.FAHRENHEIT);
        viewModel.setFromTemperature("32.0");
        viewModel.setTo(ListOfTemperatures.NEWTON);
        viewModel.calculate();

        assertEquals("0.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertKelvin0ToCelsiusAbsoluteZero() {
        viewModel.setFrom(ListOfTemperatures.KELVIN);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.calculate();

        assertEquals("-273.15", viewModel.getResultTemperature());
    }

    @Test
    public void convertKelvin0ToFahrenheitAbsoluteZero() {
        viewModel.setFrom(ListOfTemperatures.KELVIN);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.FAHRENHEIT);
        viewModel.calculate();

        assertEquals(-459.67, viewModel.getDoubleResult(), delta);
    }

    @Test
    public void convertKelvin455ToNewton60() {
        viewModel.setFrom(ListOfTemperatures.KELVIN);
        viewModel.setFromTemperature("455.0");
        viewModel.setTo(ListOfTemperatures.NEWTON);
        viewModel.calculate();

        assertEquals(60.01, viewModel.getDoubleResult(), delta);
    }

    @Test
    public void convertNewton0ToCelsius0() {
        viewModel.setFrom(ListOfTemperatures.NEWTON);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.calculate();

        assertEquals("0.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertNewton33ToCelsius100() {
        viewModel.setFrom(ListOfTemperatures.NEWTON);
        viewModel.setFromTemperature("33.0");
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.calculate();

        assertEquals("100.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertNewton0ToFahrenheit32() {
        viewModel.setFrom(ListOfTemperatures.NEWTON);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.FAHRENHEIT);
        viewModel.calculate();

        assertEquals("32.0", viewModel.getResultTemperature());
    }

    @Test
    public void convertNewton61ToKelvin458() {
        viewModel.setFrom(ListOfTemperatures.NEWTON);
        viewModel.setFromTemperature("61.0");
        viewModel.setTo(ListOfTemperatures.KELVIN);
        viewModel.calculate();

        assertEquals(457.998, viewModel.getDoubleResult(), delta);
    }

    @Test
    public void convertCelsius0ToCelsius0() {
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.setFromTemperature("0.0");
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.calculate();

        assertEquals("0.0", viewModel.getResultTemperature());
    }
    @Test
    public void convertCelsius100ToCelsius100() {
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.setFromTemperature("100.0");
        viewModel.setTo(ListOfTemperatures.CELSIUS);
        viewModel.calculate();

        assertEquals("100.0", viewModel.getResultTemperature());
    }
}
