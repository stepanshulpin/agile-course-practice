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

    public ViewModel() {
        stackDouble = new Stack<Double>();
        isStackEmptyInfo.set("Stack is empty");
        stackSize.set("0");
        topElement.set("None");
        popElement.set("None");
        pushElement.set("");
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
        return "";
    }

}
