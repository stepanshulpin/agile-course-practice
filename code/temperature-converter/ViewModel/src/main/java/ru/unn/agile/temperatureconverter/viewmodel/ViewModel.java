package ru.unn.agile.temperatureconverter.viewmodel;

import ru.unn.agile.temperatureconverter.model.TemperatureConverter;
import ru.unn.agile.temperatureconverter.model.CelsiusTemperature;
import ru.unn.agile.temperatureconverter.model.NewtonTemperature;
import ru.unn.agile.temperatureconverter.model.Temperature;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewModel {
    private String fromTemperature;

    private String resultTemperature;
    private String statusText;
    private ListOfTemperatures listTemperaturesFrom;
    private ListOfTemperatures listTemperaturesTo;
    private boolean isConvertButtonEnabled;
    private boolean isErrorMessageDisplayed;

    private String patternInput = "-?(\\d+)(\\.(\\d+))?";

    public enum ListOfTemperatures {
        CELSIUS("Celsius"),
        NEWTON("Newton");
        private final String temperature;

        ListOfTemperatures(final String temperature) {
            this.temperature = temperature;
        }
        public String toString() {
            return temperature;
        }
    }

    public String getFromTemperature() {
        return fromTemperature;
    }

    public String getResultTemperature() {
        return resultTemperature;
    }

    public String getStatusText() {
        return statusText;
    }

    public ListOfTemperatures getFrom() {
        return listTemperaturesFrom;
    }

    public ListOfTemperatures getTo() {
        return listTemperaturesTo;
    }

    public boolean isConvertButtonEnabled() {
        return isConvertButtonEnabled;
    }

    public boolean isErrorMessageDisplayed() {
        return isErrorMessageDisplayed;
    }

    public ViewModel() {
        resultTemperature = "";
        fromTemperature = "";
        listTemperaturesFrom = ListOfTemperatures.CELSIUS;
        listTemperaturesTo = ListOfTemperatures.CELSIUS;
        statusText = "";
        isConvertButtonEnabled = false;
    }

    public void setFromTemperature(final String fromTemperature) {
        this.fromTemperature = fromTemperature;
    }
    public void setFrom(final ListOfTemperatures listTemperaturesFrom) {
        this.resultTemperature = "";
        this.listTemperaturesFrom = listTemperaturesFrom;
    }
    public void setTo(final ListOfTemperatures listTemperaturesTo) {
        this.resultTemperature = "";
        this.listTemperaturesTo = listTemperaturesTo;
    }

    private boolean matchInput(final String line, final String pattern) {
        boolean result = false;
        Pattern p  = Pattern.compile(pattern);
        if (!line.isEmpty()) {
            Matcher m = p.matcher(line);
            result = m.matches();
        }
        return result;
    }

    private boolean isCorrectInputForFirstGroupOperation() {
        boolean matchTempFrom = matchInput(getFromTemperature(), patternInput);
        if (matchTempFrom) {
            return true;
        }
        return false;
    }
    private void setError() {
        if (isErrorMessageDisplayed) {
            statusText = "Error. Please enter correct temperature";
        } else {
            statusText = "";
        }
    }

    public void processInput() {
        boolean validation1 = isCorrectInputForFirstGroupOperation();
        if (validation1) {
            isConvertButtonEnabled = true;
            isErrorMessageDisplayed = false;
        } else {
            isConvertButtonEnabled = false;
            isErrorMessageDisplayed = true;
        }
        setError();
    }

    public void calculate() {
        processInput();
        if (isConvertButtonEnabled()) {
            resultTemperature = "";
            TemperatureConverter converter = new TemperatureConverter();
            Temperature fromClass;
            Temperature toClass;

            if (getFrom().equals(ListOfTemperatures.CELSIUS)) {
              //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                fromClass = new CelsiusTemperature(fromTemperature);
            } else { //if (getFrom().equals(ListOfTemperatures.NEWTON)) {
                //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                fromClass = new NewtonTemperature(fromTemperature);
            }

            if (getTo().equals(ListOfTemperatures.CELSIUS)) {
                //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                toClass = converter.convert(fromClass, CelsiusTemperature.class);
            } else { //          if (getFrom().equals(ListOfTemperatures.NEWTON)) {
                //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                toClass = converter.convert(fromClass, NewtonTemperature.class);
            }
            resultTemperature = "" + toClass.getValue();
        }
    }
}
