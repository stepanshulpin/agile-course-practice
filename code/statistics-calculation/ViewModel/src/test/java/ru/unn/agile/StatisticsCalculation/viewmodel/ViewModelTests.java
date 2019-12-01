package ru.unn.agile.StatisticsCalculation.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import ru.unn.agile.ComplexNumber.model.ComplexNumber.Operation;

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
    public void canSetDefaultValuesTextFields() {
        assertEquals("", viewModel.newProbabilitieProperty().get());
        assertEquals("", viewModel.newValueProperty().get());
    }
    @Test
    public void canSetDefaultValuesLabels() {
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(OperationStatus.WAITING.toString(), viewModel.operationStatusProperty().get());
        assertEquals(DataStatus.WAITING.toString(), viewModel.dataStatusProperty().get());
    }
    @Test
    public void canSetDefaultButtons() {
        assertEquals(true, viewModel.calculationDisabledProperty().get());
        assertEquals(true, viewModel.deleteDisabledProperty().get());
    }
}
