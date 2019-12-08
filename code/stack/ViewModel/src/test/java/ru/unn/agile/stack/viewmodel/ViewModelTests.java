package ru.unn.agile.stack.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void checkDefaultEmptyStatus() {
        var emptyStatus = "Stack is empty";
        assertEquals(emptyStatus, viewModel.getIsStackEmptyInfoProperty());
    }

    @Test
    public void checkDefaultStackSize() {
        var defaultSize = "0";
        assertEquals(defaultSize, viewModel.getStackSizeProperty());
    }

    @Test
    public void checkDefaultTopElement() {
        var defaultTopElement = "None";
        assertEquals(defaultTopElement, viewModel.getTopElementProperty());
    }

    @Test
    public void checkDefaultPopElement() {
        var defaultPopElement = "None";
        assertEquals(defaultPopElement, viewModel.getPopElementProperty());
    }

    @Test
    public void checkDefaultPushElement() {
        var defaultPushElement = "";
        assertEquals(defaultPushElement, viewModel.getPushElementProperty());
    }

    @Test
    public void checkDefaultStatus() {
        var defaultStatus = "Waiting for new element";
        assertEquals(defaultStatus, viewModel.getStatusProperty());
    }

    @Test
    public void checkDefaultPopButtonState() {
        assertFalse(viewModel.getDefaultPopButtonState());
    }

    @Test
    public void canPushNewElement() {
        viewModel.pushNewElement("5");

        var notEmptyStack = "Stack is not empty";
        var stackSize = "1";
        var notNoneTopElement = "5.0";
        var nonePopElement = "None";
        var pushElement = "5";
        var readyStatus = "Ready to push new element";

        assertEquals(notEmptyStack, viewModel.getIsStackEmptyInfoProperty());
        assertEquals(stackSize, viewModel.getStackSizeProperty());
        assertEquals(notNoneTopElement, viewModel.getTopElementProperty());
        assertEquals(nonePopElement, viewModel.getPopElementProperty());
        assertEquals(pushElement, viewModel.getPushElementProperty());
        assertEquals(readyStatus, viewModel.getStatusProperty());
    }

    @Test
    public void canNotPushInvalidFormat() {
        viewModel.pushNewElement("k");

        var emptyStack = "Stack is empty";
        var stackSize = "0";
        var noneTopElement = "None";
        var nonePopElement = "None";
        var emptyPushElement = "";
        var invalidStatus = "Invalid format of the pushing element";

        assertEquals(emptyStack, viewModel.getIsStackEmptyInfoProperty());
        assertEquals(stackSize, viewModel.getStackSizeProperty());
        assertEquals(noneTopElement, viewModel.getTopElementProperty());
        assertEquals(nonePopElement, viewModel.getPopElementProperty());
        assertEquals(emptyPushElement, viewModel.getPushElementProperty());
        assertEquals(invalidStatus, viewModel.getStatusProperty());
    }

    @Test
    public void canPopElement() {
        viewModel.pushNewElement("1");
        viewModel.popElement();

        var emptyStack = "Stack is empty";
        var stackSize = "0";
        var noneTopElement = "None";
        var notNonePopElement = "1.0";
        var pushElement = "1";
        var readyStatus = "Ready to push new element";

        assertEquals(emptyStack, viewModel.getIsStackEmptyInfoProperty());
        assertEquals(stackSize, viewModel.getStackSizeProperty());
        assertEquals(noneTopElement, viewModel.getTopElementProperty());
        assertEquals(notNonePopElement, viewModel.getPopElementProperty());
        assertEquals(pushElement, viewModel.getPushElementProperty());
        assertEquals(readyStatus, viewModel.getStatusProperty());
    }

    @Test
    public void canNotPopElementFromEmptyStack() {
        viewModel.popElement();

        var emptyStack = "Stack is empty";
        var nullStackSize = "0";
        var noneTopElement = "None";
        var nonePopElement = "None";
        var emptyPushElement = "";
        var waitingStatus = "Waiting for new element";

        assertEquals(emptyStack, viewModel.getIsStackEmptyInfoProperty());
        assertEquals(nullStackSize, viewModel.getStackSizeProperty());
        assertEquals(noneTopElement, viewModel.getTopElementProperty());
        assertEquals(nonePopElement, viewModel.getPopElementProperty());
        assertEquals(emptyPushElement, viewModel.getPushElementProperty());
        assertEquals(waitingStatus, viewModel.getStatusProperty());
    }

    @Test
    public void isPopButtonEnabledForNotEmptyStack() {
        viewModel.pushNewElement("1.0");
        assertTrue(viewModel.getDefaultPopButtonState());
    }

    @Test
    public void isPopButtonDisabledForEmptyStack() {
        viewModel.pushNewElement("1.0");
        viewModel.popElement();
        assertFalse(viewModel.getDefaultPopButtonState());
    }

    @Test
    public void isPopButtonDisabledWhenPushInvalidElement() {
        viewModel.pushNewElement("abc");
        assertFalse(viewModel.getDefaultPopButtonState());
    }

    @Test
    public void canWorkCorrectlyWithSeveralPush() {
        viewModel.pushNewElement("1");
        viewModel.pushNewElement("2");
        viewModel.pushNewElement("3");

        var notEmptyStack = "Stack is not empty";
        var stackSize = "3";
        var notNoneTopElement = "3.0";
        var nonePopElement = "None";
        var notNullPushElement = "3";
        var readyStatus = "Ready to push new element";

        assertEquals(notEmptyStack, viewModel.getIsStackEmptyInfoProperty());
        assertEquals(stackSize, viewModel.getStackSizeProperty());
        assertEquals(notNoneTopElement, viewModel.getTopElementProperty());
        assertEquals(nonePopElement, viewModel.getPopElementProperty());
        assertEquals(notNullPushElement, viewModel.getPushElementProperty());
        assertEquals(readyStatus, viewModel.getStatusProperty());
    }

    @Test
    public void canWorkCorrectlyWithSeveralPop() {
        viewModel.pushNewElement("1");
        viewModel.pushNewElement("2");
        viewModel.pushNewElement("3");
        viewModel.popElement();
        viewModel.popElement();

        var notEmptyStack = "Stack is not empty";
        var stackSize = "1";
        var notNoneTopElement = "1.0";
        var notNonePopElement = "2.0";
        var notNullPushElement = "3";
        var readyStatus = "Ready to push new element";
        assertEquals(notEmptyStack, viewModel.getIsStackEmptyInfoProperty());
        assertEquals(stackSize, viewModel.getStackSizeProperty());
        assertEquals(notNoneTopElement, viewModel.getTopElementProperty());
        assertEquals(notNonePopElement, viewModel.getPopElementProperty());
        assertEquals(notNullPushElement, viewModel.getPushElementProperty());
        assertEquals(readyStatus, viewModel.getStatusProperty());
    }
}
