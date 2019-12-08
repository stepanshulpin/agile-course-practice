package ru.unn.agile.stack.viewmodel;

import ru.unn.agile.stack.model.Stack;
import javafx.beans.property.*;

public class ViewModel {
    private Stack<Double> stackDouble;
    private final StringProperty isStackEmptyInfo = new SimpleStringProperty();
    private final StringProperty stackSize = new SimpleStringProperty();
    private final StringProperty topElement = new SimpleStringProperty();
    private final StringProperty popElement = new SimpleStringProperty();
    private final StringProperty pushElement = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private boolean popButtonState;

    public ViewModel() {
        stackDouble = new Stack<Double>();
        isStackEmptyInfo.set("Stack is empty");
        stackSize.set("0");
        topElement.set("None");
        popElement.set("None");
        pushElement.set("");
        status.set(Status.WAITING.toString());
        popButtonState = false;
    }

    public String getIsStackEmptyInfoProperty() {
        return isStackEmptyInfo.get();
    }

    public String getStackSizeProperty() {
        return stackSize.get();
    }

    public String getTopElementProperty() {
        return topElement.get();
    }

    public String getPopElementProperty() {
        return popElement.get();
    }

    public String getPushElementProperty() {
        return pushElement.get();
    }

    public String getStatusProperty() {
        return status.get();
    }

    public boolean getDefaultPopButtonState() {
        return popButtonState;
    }

    private void changePopButtonState() {
        popButtonState = !stackDouble.isEmpty();
    }

    private void changeStackEmptyInfo() {
        if (stackDouble.isEmpty()) {
            isStackEmptyInfo.set("Stack is empty");
        } else {
            isStackEmptyInfo.set("Stack is not empty");
        }
    }

    private void changeStackSize() {
        int doubleStackSize = stackDouble.size();
        stackSize.set(Integer.toString(doubleStackSize));
    }

    private void changeStackTopElement() {
        if (!stackDouble.isEmpty()) {
            topElement.set(Double.toString(stackDouble.peek()));
        } else {
            topElement.set("None");
        }
    }

    private boolean checkInput(final String inputElement) {
        if (inputElement.isEmpty()) {
            status.set(Status.WAITING.toString());
            return false;
        }

        try {
            Double.parseDouble(inputElement);
        } catch (Exception e) {
            status.set(Status.BAD_FORMAT.toString());
            return false;
        }

        status.set(Status.READY.toString());
        return true;
    }

    public void pushNewElement(final String inputElement) {
        if (checkInput(inputElement)) {
            pushElement.set(inputElement);
            stackDouble.push(Double.parseDouble(inputElement));
            changeStackSize();
            changePopButtonState();
            changeStackEmptyInfo();
            changeStackTopElement();
        }
    }

    public void popElement() {
        if (!stackDouble.isEmpty()) {
            popElement.set(Double.toString(stackDouble.pop()));
            changePopButtonState();
            changeStackEmptyInfo();
            changeStackSize();
            changeStackTopElement();
        }
    }

}

enum Status {
    WAITING("Waiting for new element"),
    READY("Ready to push new element"),
    BAD_FORMAT("Invalid format of the pushing element");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
