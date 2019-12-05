package ru.unn.agile.Queue.viewmodel;

public class ViewModel {
    private String queueString;
    private String inputElement;

    public ViewModel() {
        inputElement = "";
        queueString = "";
    }

    public String getQueueString() {
        return queueString;
    }

    public String getInputElement() {
        return inputElement;
    }
}
