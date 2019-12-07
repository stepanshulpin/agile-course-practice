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
        Pattern p  = Pattern.compile(pattern);

        if (line.isEmpty()) {
            return false;
        }

        Matcher m = p.matcher(line);
        if (m.matches()) {
            statusText = "";
            return true;
        } else {
            statusText = "Error. Please enter correct temperature";
            return false;
        }
    }

    public boolean checkTemperature(final String fromTemperature, final ListOfTemperatures from) {
        try {
            if (from.equals(ListOfTemperatures.CELSIUS)) {
                //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                CelsiusTemperature fromClass = new CelsiusTemperature(fromTemperature);
            } else { //if (getFrom().equals(ListOfTemperatures.NEWTON)) {
                //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                NewtonTemperature fromClass = new NewtonTemperature(fromTemperature);
            }
        } catch (IllegalArgumentException e) {
            if (statusText.isEmpty()) {
                statusText = e.getMessage();
            }
            return false;
        }
        statusText = "";
        return true;
    }

    public void processInput() {
        boolean validationInput = matchInput(getFromTemperature(), patternInput);
        boolean validationWithAbsoluteZero = checkTemperature(getFromTemperature(), getFrom());
        if (validationInput && validationWithAbsoluteZero) {
            isConvertButtonEnabled = true;
            isErrorMessageDisplayed = false;
        } else {
            isConvertButtonEnabled = false;
            isErrorMessageDisplayed = true;
        }
    }

    public void calculate() {
        processInput();
        if (isConvertButtonEnabled()) {
            resultTemperature = "";
            TemperatureConverter converter = new TemperatureConverter();
            Temperature fromClass;
            Temperature toClass;

            if (getFrom().equals(ListOfTemperatures.CELSIUS)) {
                fromClass = new CelsiusTemperature(fromTemperature);
            } else { //if (getFrom().equals(ListOfTemperatures.NEWTON)) {
                fromClass = new NewtonTemperature(fromTemperature);
            }


            if (getTo().equals(ListOfTemperatures.CELSIUS)) {
                toClass = converter.convert(fromClass, CelsiusTemperature.class);
            } else { //          if (getFrom().equals(ListOfTemperatures.NEWTON)) {
                //  CelsiusTemperature celsius = new CelsiusTemperature(0.0);
                toClass = converter.convert(fromClass, NewtonTemperature.class);
            }
            resultTemperature = "" + toClass.getValue();
        }
    }
}
