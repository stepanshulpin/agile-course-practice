package ru.unn.agile.stack.viewmodel;

import ru.unn.agile.stack.model.Stack;

public class ViewModel {
    private Stack<Double> stackDouble;
    private String isStackEmptyInfo;

    public ViewModel() {
        stackDouble = new Stack<Double>();
        isStackEmptyInfo = "Stack is empty";
    }

    public String getIsStackEmptyInfo() {
        return "Stack is empty";
    }
}
