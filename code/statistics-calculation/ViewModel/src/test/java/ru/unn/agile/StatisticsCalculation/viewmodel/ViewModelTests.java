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
        assertEquals(OperationStatus.WAITING_OPERATION.toString(), viewModel.getOperationStatus());
        assertEquals(DataStatus.WAITING.toString(), viewModel.getDataStatus());
        assertEquals(InputDataStatus.WAITING.toString(), viewModel.getInputDataStatus());
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

        viewModel.updateTableElement();

        assertEquals("1", viewModel.getListData().get(0).getValue());
        assertEquals("0.2", viewModel.getListData().get(0).getProbabilitie());
    }
    @Test
    public void canAddCorrectTableElementAndCheckStatusWaiting() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("0.2");

        viewModel.updateTableElement();

        assertEquals(InputDataStatus.WAITING.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canNotAddTableElementWithProbabilitieMoreThen1() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("1.1");

        viewModel.updateTableElement();

        assertEquals(true, viewModel.getListData().isEmpty());
        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canNotAddTableElementWithProbabilitieMoreThen1AndStatusBad() {
        viewModel.newValueProperty().set("1");
        viewModel.newProbabilitieProperty().set("1.1");

        viewModel.updateTableElement();

        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.inputDataStatusProperty().get());
    }
    @Test
    public void canPushAddButtonWithCorrectInput() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("0.5");

        assertEquals(false, viewModel.isUpdateDisabled());
    }
    @Test
    public void canNotPushAddButtonWithDoubleInputInValue() {
        viewModel.newValueProperty().set("2.1");
        viewModel.newProbabilitieProperty().set("0.2");

        assertEquals(true, viewModel.isUpdateDisabled());
    }
    @Test
    public void canNotPushAddButtonWithUncorrectInput() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("1.5");

        assertEquals(true, viewModel.isUpdateDisabled());
    }
    @Test
    public void canSetInputDataWaitingWithEmptyProperty() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("");

        assertEquals(InputDataStatus.WAITING.toString(), viewModel.getInputDataStatus());
    }
    @Test
    public void canSetInputDataBadFormatWithErrorProbabilitie() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("10");

        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.getInputDataStatus());
    }
    @Test
    public void canSetInputDataBadFormatWithString() {
        viewModel.newValueProperty().set("hello");
        viewModel.newProbabilitieProperty().set("!");

        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.getInputDataStatus());
    }
    @Test
    public void canSetInputDataBadFormatWithOneError() {
        viewModel.newValueProperty().set("hello");
        viewModel.newProbabilitieProperty().set("0.1");

        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.getInputDataStatus());
    }
    @Test
    public void canSetInputDataBadFormatWithDoubleInValue() {
        viewModel.newValueProperty().set("1.1");
        viewModel.newProbabilitieProperty().set("0.1");

        assertEquals(InputDataStatus.BAD_FORMAT.toString(), viewModel.getInputDataStatus());
    }
    @Test
    public void canSetInputDataReady() {
        viewModel.newValueProperty().set("2");
        viewModel.newProbabilitieProperty().set("0.4");

        assertEquals(InputDataStatus.READY.toString(), viewModel.getInputDataStatus());
    }
    @Test
    public void canUpdateSelectedElement() {
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.1");
        viewModel.updateTableElement();

        viewModel.newValueProperty().set("20");
        viewModel.newProbabilitieProperty().set("0.2");
        viewModel.updateTableElement(0);

        assertEquals("20", viewModel.getListData().get(0).getValue());
        assertEquals("0.2", viewModel.getListData().get(0).getProbabilitie());
    }
    @Test
    public void canDeleteInputData() {
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.1");

        viewModel.deleteTableElement(-1);

        assertEquals(true, viewModel.getListData().isEmpty());
        assertEquals("", viewModel.newValueProperty().get());
        assertEquals("", viewModel.newProbabilitieProperty().get());
    }
    @Test
    public void canDeleteSelectedElement() {
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.1");
        viewModel.updateTableElement();
        viewModel.newValueProperty().set("20");
        viewModel.newProbabilitieProperty().set("0.2");
        viewModel.updateTableElement();

        viewModel.deleteTableElement(1);

        assertEquals(1, viewModel.getListData().size());
        assertEquals("10", viewModel.getListData().get(0).getValue());
        assertEquals("0.1", viewModel.getListData().get(0).getProbabilitie());
    }
    @Test
    public void canHandleDeleteWithInvalidIndex() {
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.1");
        viewModel.updateTableElement();

        viewModel.deleteTableElement(2);

        assertEquals(1, viewModel.getListData().size());
        assertEquals("10", viewModel.getListData().get(0).getValue());
        assertEquals("0.1", viewModel.getListData().get(0).getProbabilitie());
    }
    @Test
    public void canSetDataStatusEnterDataByDefolt(){
        assertEquals(DataStatus.WAITING.toString(), viewModel.getDataStatus());
    }
    @Test
    public void canSetDataStatusEnterDataWithEmptyData(){
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.1");
        viewModel.updateTableElement();

        viewModel.deleteTableElement(0);

        assertEquals(DataStatus.WAITING.toString(), viewModel.getDataStatus());
    }
    @Test
    public void canSetDataStatusBadFormat(){
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.1");
        viewModel.updateTableElement();

        assertEquals(DataStatus.BAD_FORMAT.toString(), viewModel.getDataStatus());
    }
    @Test
    public void canSetDataStatusBadFormatAfterDelete(){
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.9");
        viewModel.updateTableElement();
        viewModel.newValueProperty().set("20");
        viewModel.newProbabilitieProperty().set("0.1");
        viewModel.updateTableElement();

        viewModel.deleteTableElement(1);

        assertEquals(DataStatus.BAD_FORMAT.toString(), viewModel.getDataStatus());
    }
    @Test
    public void canSetDataStatusReady(){
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("1");
        viewModel.updateTableElement();

        assertEquals(DataStatus.READY.toString(), viewModel.getDataStatus());
    }
    @Test
    public void canSetDataStatusReadyAfterDelete(){
        viewModel.newValueProperty().set("10");
        viewModel.newProbabilitieProperty().set("0.8");
        viewModel.updateTableElement();
        viewModel.newValueProperty().set("20");
        viewModel.newProbabilitieProperty().set("0.2");
        viewModel.updateTableElement();
        viewModel.newValueProperty().set("30");
        viewModel.newProbabilitieProperty().set("0.3");
        viewModel.updateTableElement();

        viewModel.deleteTableElement(2);

        assertEquals(DataStatus.READY.toString(), viewModel.getDataStatus());
    }
}
