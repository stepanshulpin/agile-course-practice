package ru.unn.agile.complexnumbercalculator.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import ru.unn.agile.complexnumbercalculator.viewmodel.ViewModel.Operations;

public class ViewModelTests {
    private ViewModel viewModel;
    private int ENTER = 10;

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
    public void checkResultIsShownAfterEnterIsPressed() {
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("2");
        viewModel.setSecondRe("3");
        viewModel.setSecondIm("4");
        viewModel.processEnterPress(ENTER);

        assertEquals("4.0 + 6.0i", viewModel.getResult());
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
        viewModel.hideUnnecessaryFields();
        assertEquals(true, viewModel.isDegreeVisible());
    }

    @Test
    public void checkDegreeTextBoxChangeVisibleState(){
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.ADD);
        viewModel.hideUnnecessaryFields();
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

    @Test
    public void checkDegreeTextBoxIsHiddenOnSubtractOperation(){
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.SUBTRACT);
        viewModel.hideUnnecessaryFields();
        assertEquals(false, viewModel.isDegreeVisible());
    }

    @Test
    public void checkCorrectResultIsShownForMultiplyOperation(){
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("2");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("4");

        viewModel.calculate();
        assertEquals("-7.0 + 6.0i", viewModel.getResult());
    }

    @Test
    public void checkDegreeTextBoxIsHiddenOnMultiplyOperation(){
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.hideUnnecessaryFields();
        assertEquals(false, viewModel.isDegreeVisible());
    }

    @Test
    public void checkCorrectResultIsShownForDivideOperation(){
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("3");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("3");

        viewModel.calculate();
        assertEquals("1.0 + 0.0i", viewModel.getResult());
    }

    @Test
    public void checkDegreeTextBoxIsHiddenOnDivideOperation(){
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.hideUnnecessaryFields();
        assertEquals(false, viewModel.isDegreeVisible());
    }

    @Test
    public void checkCalculateButtonDisabledForDivideWithZero(){
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("0");
        viewModel.setSecondIm("0");

        viewModel.processInput();

        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkCorrectResultIsShownForPowOperation(){
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("3");
        viewModel.setDegree("1");

        viewModel.calculate();
        assertEquals("1.0 + 3.0i", viewModel.getResult());
    }

    @Test
    public void checkSecondNumberFieldsAreHiddenForPow(){
        viewModel.setOperations(Operations.POW);

        viewModel.hideUnnecessaryFields();
        assertEquals(false, viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkCalculateButtonIsDisabledWhenDegreeIsDouble(){
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1.0");
        viewModel.processInput();
        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenDegreeIsDouble(){
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1.0");
        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonIsDisabledWhenDegreeIsNotNumber(){
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("abc");
        viewModel.processInput();
        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenDegreeIsNotNumber(){
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("abc");
        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenInputWithDegreeNotFull(){
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1");
        viewModel.processInput();
        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputWithDegreeNotFull(){
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1");
        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenDegreeInputEmpty(){
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("");

        viewModel.processInput();

        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenDegreeInputEmpty(){
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("");

        viewModel.processInput();
        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonEnabledWhenInputWithDegreeOK(){
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("1");

        viewModel.processInput();

        assertEquals(true, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsHiddenWhenInputWithDegreeOK(){
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("1");

        viewModel.processInput();

        assertEquals(false, viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnAddOperation(){
        viewModel.setOperations(Operations.ADD);
        viewModel.hideUnnecessaryFields();
        assertEquals(true, viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnSubtractOperation(){
        viewModel.setOperations(Operations.SUBTRACT);
        viewModel.hideUnnecessaryFields();
        assertEquals(true, viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnMultiplyOperation(){
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.hideUnnecessaryFields();
        assertEquals(true, viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnDivideOperation(){
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.hideUnnecessaryFields();
        assertEquals(true, viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxChangeVisibleState(){
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.hideUnnecessaryFields();
        assertEquals(true, viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkCalculateButtonDisabledAfterPressInCaseIncorrectInput(){
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("");

        viewModel.calculate();

        assertEquals(false, viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageDisplayedAfterPressInCaseIncorrectInput(){
        viewModel.setOperations(Operations.ADD);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("");

        viewModel.calculate();

        assertEquals(true, viewModel.isErrorMessageDisplayed());
    }
}