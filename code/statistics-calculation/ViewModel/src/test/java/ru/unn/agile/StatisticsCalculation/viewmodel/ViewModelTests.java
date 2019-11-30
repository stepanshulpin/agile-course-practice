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
    public void canSetDefaultValues() {
        assertEquals("", viewModel.newValueProperty().get());
        assertEquals("", viewModel.newProbabilitieProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }
}
