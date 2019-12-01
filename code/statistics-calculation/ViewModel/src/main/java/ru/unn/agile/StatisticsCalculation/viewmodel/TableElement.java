package ru.unn.agile.StatisticsCalculation.viewmodel;

public class TableElement {
    private String value;
    private String probabilitie;

    public TableElement(String value, String probabilitie) {
        this.value = value;
        this.probabilitie = probabilitie;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProbabilitie() {
        return probabilitie;
    }

    public void setProbabilitie(String probabilitie) {
        this.probabilitie = probabilitie;
    }
}
