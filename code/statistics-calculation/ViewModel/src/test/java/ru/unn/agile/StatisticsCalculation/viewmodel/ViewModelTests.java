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
        assertEquals(InputDataStatus.WAITING.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canSetDefaultButtons() {
        assertEquals(false, viewModel.calculationDisabledProperty().get());
        assertEquals(false, viewModel.deleteDisabledProperty().get());
    }
    @Test
    public void canAddCorrectTableElement() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("0.2");

        viewModel.addNewTableElement();

        assertEquals("1", viewModel.getListData().get(0).getValue());
        assertEquals("0.2", viewModel.getListData().get(0).getProbabilitie());
    }
    @Test
    public void canAddCorrectTableElementAndCheckStatusWaiting() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("0.2");

        viewModel.addNewTableElement();

        assertEquals(InputDataStatus.WAITING.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canNotAddTableElementWithProbabilitieMoreThen1() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("1.1");

        viewModel.addNewTableElement();

        assertEquals(true, viewModel.getListData().isEmpty());
        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canNotAddTableElementWithProbabilitieMoreThen1AndStatusBad() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("1.1");

        viewModel.addNewTableElement();

        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canPushAddButtonWithCorrectInput() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("0.5");

        assertEquals(false, viewModel.isUpdateDisabled());
    }
    @Test
    public void canNotPushAddButtonWithUncorrectInput() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("1.5");

        assertEquals(true, viewModel.isUpdateDisabled());
    }
}
