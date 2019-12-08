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

    @Test
    public void calculateL1DistanceOperationsHasCorrectResult() {
        setMixedInputVectors();
        viewModel.calculate();
        String expectedL1 = "27.0";
        String actualL1 = viewModel.resultProperty().get();
        assertEquals(expectedL1, actualL1);
    }

    @Test
    public void calculateL2DistanceOperationsHasCorrectResult() {
        setMixedInputVectors();
        viewModel.operationProperty().set(Operation.CALCULATE_L2_DISTANCE);
        viewModel.calculate();
        String expectedL2 = "15.84297951775486";
        String actualL2 = viewModel.resultProperty().get();
        assertEquals(expectedL2, actualL2);
    }

    @Test
    public void calculateL3DistanceOperationsHasCorrectResult() {
        setMixedInputVectors();
        viewModel.operationProperty().set(Operation.CALCULATE_L3_DISTANCE);
        viewModel.calculate();
        String expectedL3 = "13.394235286753611";
        String actualL3 = viewModel.resultProperty().get();
        assertEquals(expectedL3, actualL3);
    }

    @Test
    public void calculateL4DistanceOperationsHasCorrectResult() {
        setMixedInputVectors();
        viewModel.operationProperty().set(Operation.CALCULATE_L4_DISTANCE);
        viewModel.calculate();
        String expectedL4 = "12.394865018039264";
        String actualL4 = viewModel.resultProperty().get();
        assertEquals(expectedL4, actualL4);
    }

    @Test
    public void calculateLInfDistanceOperationsHasCorrectResult() {
        setMixedInputVectors();
        viewModel.operationProperty().set(Operation.CALCULATE_LInf_DISTANCE);
        viewModel.calculate();
        String expectedLInf = "11.0";
        String actualLInf = viewModel.resultProperty().get();
        assertEquals(expectedLInf, actualLInf);
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
