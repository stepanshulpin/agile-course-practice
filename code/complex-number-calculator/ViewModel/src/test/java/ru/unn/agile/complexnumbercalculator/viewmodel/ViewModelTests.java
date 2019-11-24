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
        viewModel.processFields(0);

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

    @Test
    public void checkDegreeTextBoxIsVisibleOnPowOperation(){
        viewModel.setOperations(Operations.POW);
        viewModel.processFields(0);
        assertEquals(true, viewModel.isDegreeVisible());
    }

    @Test
    public void checkDegreeTextBoxChangeVisibleState(){
        viewModel.setOperations(Operations.POW);
        viewModel.setOperations(Operations.ADD);
        viewModel.processFields(0);
        assertEquals(false, viewModel.isDegreeVisible());
    }

    @Test
    public void checkCalculateButtonIsDisabledWhenInputIncorrect(){
        viewModel.setFirstRe("abc");
        viewModel.processInput();
        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputIncorrect(){
        viewModel.setFirstRe("abc");
        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenInputNotFull(){
        viewModel.setFirstRe("1");
        viewModel.processInput();
        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputNotFull(){
        viewModel.setFirstRe("1");
        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenInputEmpty(){
        viewModel.setFirstRe("");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();

        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputEmpty(){
        viewModel.setFirstRe("");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonEnabledWhenInputOK(){
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();

        assertEquals(true, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsHiddenWhenInputOK(){
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();
        assertEquals(false, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCorrectResultIsShownForSubtractOperation(){
        viewModel.setOperations(Operations.SUBTRACT);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.calculate();
        assertEquals("0.0 + 0.0i", viewModel.getResult());
    }

}