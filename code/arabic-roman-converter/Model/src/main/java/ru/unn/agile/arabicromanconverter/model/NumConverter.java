package ru.unn.agile.arabicromanconverter.model;

public interface NumConverter {
    String convert(String number);

    boolean validate(String number);
}
