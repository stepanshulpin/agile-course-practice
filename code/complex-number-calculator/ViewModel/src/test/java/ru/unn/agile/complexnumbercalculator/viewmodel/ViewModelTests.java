package ru.unn.agile.complexnumbercalculator.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import ru.unn.agile.complexnumbercalculator.viewmodel.ViewModel.Operations;

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
        assertEquals(Operations.ADD, viewModel.getOperations());
        assertEquals("", viewModel.getFirstRe());
        assertEquals("", viewModel.getFirstIm());
        assertEquals("", viewModel.getSecondRe());
        assertEquals("", viewModel.getSecondIm());
        assertEquals("", viewModel.getDegree());
        assertEquals("", viewModel.getError());
        assertEquals("", viewModel.getResult());
    }

    @Test
    public void checkButtonIsDisabledByDefault(){
        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkButtonIsEnabledIfDataFieldsAreFilled() {
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("2");
        viewModel.setSecondRe("3");
        viewModel.setSecondIm("4");
        viewModel.processTextFieldFilling(0);

        assertEquals(true, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkResultIsShownAfterButtonIsPressed() {
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("2");
        viewModel.setSecondRe("3");
        viewModel.setSecondIm("4");
        viewModel.calculate();

        assertEquals("4.0 + 6.0i", viewModel.getResult());
    }

    @Test
    public void checkDegreeTextBoxIsHiddenOnAddOperation(){
        assertEquals(false, viewModel.isDegreeVisible());
    }
}