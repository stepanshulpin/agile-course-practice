package ru.unn.agile.complexnumbercalculator.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import ru.unn.agile.complexnumbercalculator.viewmodel.ViewModel.Operations;

public class ViewModelTests {
    private ViewModel viewModel;
    private static final int ENTER = 10;

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
    public void checkButtonIsDisabledByDefault() {
        assertFalse(viewModel.isCalculateButtonEnabled());
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
    public void checkDegreeTextBoxIsHiddenOnAddOperation() {
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkDegreeTextBoxIsVisibleOnPowOperation() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isDegreeVisible());
    }

    @Test
    public void checkDegreeTextBoxChangeVisibleState() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.ADD);
        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkCalculateButtonIsDisabledWhenInputIncorrect() {
        viewModel.setFirstRe("abc");
        viewModel.processInput();
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputIncorrect() {
        viewModel.setFirstRe("abc");
        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenInputNotFull() {
        viewModel.setFirstRe("1");
        viewModel.processInput();
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputNotFull() {
        viewModel.setFirstRe("1");
        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenInputEmpty() {
        viewModel.setFirstRe("");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();

        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputEmpty() {
        viewModel.setFirstRe("");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonEnabledWhenInputOK() {
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();

        assertTrue(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsHiddenWhenInputOK() {
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.processInput();
        assertFalse(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCorrectResultIsShownForSubtractOperation() {
        viewModel.setOperations(Operations.SUBTRACT);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("1");

        viewModel.calculate();
        assertEquals("0.0 + 0.0i", viewModel.getResult());
    }

    @Test
    public void checkDegreeTextBoxIsHiddenOnSubtractOperation() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.SUBTRACT);
        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkCorrectResultIsShownForMultiplyOperation() {
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("2");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("4");

        viewModel.calculate();
        assertEquals("-7.0 + 6.0i", viewModel.getResult());
    }

    @Test
    public void checkDegreeTextBoxIsHiddenOnMultiplyOperation() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkCorrectResultIsShownForDivideOperation() {
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("3");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("3");

        viewModel.calculate();
        assertEquals("1.0 + 0.0i", viewModel.getResult());
    }

    @Test
    public void checkDegreeTextBoxIsHiddenOnDivideOperation() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkCalculateButtonDisabledForDivideWithZero() {
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("0");
        viewModel.setSecondIm("0");

        viewModel.processInput();

        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkCalculateButtonEnabledForDivideWithZeroInRe() {
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("0");
        viewModel.setSecondIm("1");

        viewModel.processInput();

        assertTrue(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkCalculateButtonDisabledForDivideWithZeroInIm() {
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("0");

        viewModel.processInput();

        assertTrue(viewModel.isCalculateButtonEnabled());
    }
    @Test
    public void checkCorrectResultIsShownForPowOperation() {
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("3");
        viewModel.setDegree("1");

        viewModel.calculate();
        assertEquals("1.0 + 3.0i", viewModel.getResult());
    }

    @Test
    public void checkSecondNumberFieldsAreHiddenForPow() {
        viewModel.setOperations(Operations.POW);

        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkCalculateButtonIsDisabledWhenDegreeIsDouble() {
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1.0");
        viewModel.processInput();
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenDegreeIsDouble() {
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1.0");
        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonIsDisabledWhenDegreeIsNotNumber() {
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("abc");
        viewModel.processInput();
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenDegreeIsNotNumber() {
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("abc");
        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenInputWithDegreeNotFull() {
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1");
        viewModel.processInput();
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenInputWithDegreeNotFull() {
        viewModel.setOperations(Operations.POW);
        viewModel.setDegree("1");
        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonDisabledWhenDegreeInputEmpty() {
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("");

        viewModel.processInput();

        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsDisplayedWhenDegreeInputEmpty() {
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("");

        viewModel.processInput();
        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCalculateButtonEnabledWhenInputWithDegreeOK() {
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("1");

        viewModel.processInput();

        assertTrue(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageIsHiddenWhenInputWithDegreeOK() {
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("1");

        viewModel.processInput();

        assertFalse(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnAddOperation() {
        viewModel.setOperations(Operations.ADD);
        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnSubtractOperation() {
        viewModel.setOperations(Operations.SUBTRACT);
        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnMultiplyOperation() {
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxIsVisibleOnDivideOperation() {
        viewModel.setOperations(Operations.DIVIDE);
        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkSecondNumberTextBoxChangeVisibleState() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.MULTIPLY);
        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkCalculateButtonDisabledAfterPressInCaseIncorrectInput() {
        viewModel.setOperations(Operations.POW);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setDegree("");

        viewModel.calculate();

        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkErrorMessageDisplayedAfterPressInCaseIncorrectInput() {
        viewModel.setOperations(Operations.ADD);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.setSecondRe("1");
        viewModel.setSecondIm("");

        viewModel.calculate();

        assertTrue(viewModel.isErrorMessageDisplayed());
    }

    @Test
    public void checkCorrectResultIsShownForRootOperation() {
        viewModel.setOperations(Operations.ROOT);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("3");
        viewModel.setDegree("1");

        viewModel.calculate();
        assertEquals("1.0 + 3.0i; ", viewModel.getResult());
    }

    @Test
    public void checkSecondNumberFieldsAreHiddenForRoot() {
        viewModel.setOperations(Operations.ROOT);

        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkDegreeFieldIsDisplayedForRoot() {
        viewModel.setOperations(Operations.ROOT);

        viewModel.hideUnnecessaryFields();
        assertTrue(viewModel.isDegreeVisible());
    }

    @Test
    public void checkButtonIsDisabledOnNegativeDegreeForRoot() {
        viewModel.setOperations(Operations.ROOT);
        viewModel.setDegree("-1");
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");

        viewModel.processInput();
        assertFalse(viewModel.isCalculateButtonEnabled());
    }

    @Test
    public void checkCorrectResultIsShownForConjugationOperation() {
        viewModel.setOperations(Operations.CONJUGATION);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("3");

        viewModel.calculate();
        assertEquals("1.0 - 3.0i", viewModel.getResult());
    }

    @Test
    public void checkSecondNumberFieldsAreHiddenForConjugation() {
        viewModel.setOperations(Operations.CONJUGATION);

        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isSecondNumberVisible());
    }

    @Test
    public void checkDegreeFieldIsHiddenForConjugation() {
        viewModel.setOperations(Operations.CONJUGATION);

        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkDegreeFieldIsHiddenForConjugationAfterPow() {
        viewModel.setOperations(Operations.POW);
        viewModel.hideUnnecessaryFields();
        viewModel.setOperations(Operations.CONJUGATION);

        viewModel.hideUnnecessaryFields();
        assertFalse(viewModel.isDegreeVisible());
    }

    @Test
    public void checkResultEmptyAfterChangeOperation() {
        viewModel.setOperations(Operations.CONJUGATION);
        viewModel.setFirstRe("1");
        viewModel.setFirstIm("1");
        viewModel.calculate();
        viewModel.setOperations(Operations.ADD);

        assertEquals("", viewModel.getResult());
    }
}
