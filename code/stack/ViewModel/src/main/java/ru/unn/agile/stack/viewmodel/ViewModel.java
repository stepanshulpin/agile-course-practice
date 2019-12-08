package ru.unn.agile.stack.viewmodel;

import ru.unn.agile.stack.model.Stack;

public class ViewModel {
    private Stack<Double> stackDouble;
    private String isStackEmptyInfo;
    private String stackSize;
    private String topElement;

    public ViewModel() {
        stackDouble = new Stack<Double>();
        isStackEmptyInfo = "Stack is empty";
        stackSize = "0";
    }

    public String getIsStackEmptyInfo() {
        return isStackEmptyInfo;
    }

    public String getStackSize() {
        return stackSize;
    }

    public String getTopElement() {
        return "None";
    }

}
