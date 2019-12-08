package ru.unn.agile.vectorsdistancescalculator.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.vectorsdistancescalculator.model.VectorsDistancesCalculator.Operation;

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
        assertEquals("", viewModel.x1Property().get());
        assertEquals("", viewModel.y1Property().get());
        assertEquals("", viewModel.z1Property().get());
        assertEquals("", viewModel.x2Property().get());
        assertEquals("", viewModel.y2Property().get());
        assertEquals("", viewModel.z2Property().get());
        assertEquals(Operation.CALCULATE_L1_DISTANCE, viewModel.operationProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormat() {
        viewModel.x1Property().set("@");
        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsWaitingIfNotEnoughCorrectData() {
        viewModel.x1Property().set("1");
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledInitially() {
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWhenFormatIsBad() {
        setPositiveInputVectors();
        viewModel.x1Property().set("KABO");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledIfNotAllFieldsFilled() {
        viewModel.x1Property().setValue("1");
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsEnabledIfDataFilledCorrect() {
        setMixedInputVectors();
        assertFalse(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void canSetCalculateLInfDistanceOperation() {
        viewModel.operationProperty().set(Operation.CALCULATE_LInf_DISTANCE);
        assertEquals(Operation.CALCULATE_LInf_DISTANCE, viewModel.operationProperty().get());
    }

    private void setPositiveInputVectors() {
        viewModel.x1Property().set("2");
        viewModel.y1Property().set("3");
        viewModel.z1Property().set("4");
        viewModel.x2Property().set("5");
        viewModel.y2Property().set("6");
        viewModel.z2Property().set("7");
    }

    private void setNegativeInputVectors() {
        viewModel.x1Property().set("-2");
        viewModel.y1Property().set("-3");
        viewModel.z1Property().set("-4");
        viewModel.x2Property().set("-5");
        viewModel.y2Property().set("-6");
        viewModel.z2Property().set("-7");
    }

    private void setMixedInputVectors() {
        viewModel.x1Property().set("-2");
        viewModel.y1Property().set("3");
        viewModel.z1Property().set("-4");
        viewModel.x2Property().set("5");
        viewModel.y2Property().set("-6");
        viewModel.z2Property().set("7");
    }



}
