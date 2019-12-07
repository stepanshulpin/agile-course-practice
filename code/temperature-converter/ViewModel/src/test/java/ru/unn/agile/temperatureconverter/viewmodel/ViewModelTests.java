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
    public void convertFromCelsiusToNewtonHasCorrectResult() {
        viewModel.setFromTemperature("0.0");
        viewModel.calculate();

        assertEquals("0.0", viewModel.getResultTemperature());
    }
/*
    @Test
    public void statusIsWaitingWhenCalculateWithEmptyFields() {
        viewModel.calculate();
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenFieldsAreFill() {
        viewModel.re1Property().set("1");
        viewModel.im1Property().set("2");
        viewModel.re2Property().set("3");
        viewModel.im2Property().set("4");

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormat() {
        viewModel.re1Property().set("a");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingIfNotEnoughCorrectData() {
        viewModel.re1Property().set("1");

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canSetSuccessMessage() {
        setInputData();

        viewModel.calculate();

        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canSetBadFormatMessage() {
        viewModel.re1Property().set("#selfie");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyWhenSetProperData() {
        setInputData();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void operationMulHasCorrectResult() {
        viewModel.re1Property().set("2");
        viewModel.im1Property().set("3");
        viewModel.re2Property().set("1");
        viewModel.im2Property().set("2");
        viewModel.operationProperty().set(Operation.MULTIPLY);

        viewModel.calculate();

        assertEquals("-4.0 + 7.0i", viewModel.resultProperty().get());
    }

    @Test
    public void operationAddWithNegativeNumbersHasCorrectResult() {
        viewModel.re1Property().set("1.2");
        viewModel.im1Property().set("2.3");
        viewModel.re2Property().set("-10.4");
        viewModel.im2Property().set("-20.5");
        viewModel.operationProperty().set(Operation.ADD);

        viewModel.calculate();

        assertEquals("-9.2 - 18.2i", viewModel.resultProperty().get());
    }

    private void setInputData() {
        viewModel.re1Property().set("1");
        viewModel.im1Property().set("2");
        viewModel.re2Property().set("3");
        viewModel.im2Property().set("4");
    }

 */
}
