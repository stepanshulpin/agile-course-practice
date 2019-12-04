package ru.unn.agile.StatisticsCalculation.viewmodel;

public class TableElement {
    private String value;
    private String probabilitie;

    public TableElement(final String value, final String probabilitie) {
        this.value = value;
        this.probabilitie = probabilitie;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getProbabilitie() {
        return probabilitie;
    }

    public void setProbabilitie(final String probabilitie) {
        this.probabilitie = probabilitie;
    }
}
