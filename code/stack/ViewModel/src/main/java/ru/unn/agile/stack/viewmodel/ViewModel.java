package ru.unn.agile.stack.viewmodel;

import ru.unn.agile.stack.model.Stack;

public class ViewModel {
    private Stack<Double> stackDouble;
    private String isStackEmptyInfo;
    private String stackSize;
    private String topElement;
    private String popElement;

    public ViewModel() {
        stackDouble = new Stack<Double>();
        isStackEmptyInfo = "Stack is empty";
        stackSize = "0";
        topElement = "None";
        popElement = "None";
    }

    public String getIsStackEmptyInfo() {
        return isStackEmptyInfo;
    }

    public String getStackSize() {
        return stackSize;
    }

    public String getTopElement() {
        return topElement;
    }

    public String getPopElement() {
        return popElement;
    }

    public String getPushElement() {
        return "";
    }

}
