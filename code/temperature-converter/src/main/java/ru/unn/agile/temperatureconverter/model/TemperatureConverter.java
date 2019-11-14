package ru.unn.agile.temperatureconverter.model;

import java.util.HashMap;
import java.util.Map;

public class TemperatureConverter {

    private ConverterCelsiusCelsius converterCelsiusCelsius;
    private ConverterCelsiusKelvin converterCelsiusKelvin;
    private ConverterCelsiusNewton converterCelsiusNewton;
    private ConverterCelsiusFahrenheit converterCelsiusFahrenheit;

    public TemperatureConverter() {
        converterCelsiusCelsius = new ConverterCelsiusCelsius();
        converterCelsiusKelvin = new ConverterCelsiusKelvin();
        converterCelsiusNewton = new ConverterCelsiusNewton();
        converterCelsiusFahrenheit = new ConverterCelsiusFahrenheit();
    }

    public FahrenheitTemperature convertToFahrenheit(final Temperature temperature) {
        Converter converterToCelsius = getConvertor(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConvertor(FahrenheitTemperature.class.getName());
        return (FahrenheitTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    public KelvinTemperature convertToKelvin(final Temperature temperature) {
        Converter converterToCelsius = getConvertor(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConvertor(KelvinTemperature.class.getName());
        return (KelvinTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final Temperature temperature) {
        Converter converterToCelsius = getConvertor(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConvertor(NewtonTemperature.class.getName());
        return (NewtonTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    public CelsiusTemperature convertToCelsius(final Temperature temperature) {
        Converter converterToCelsius = getConvertor(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConvertor(CelsiusTemperature.class.getName());
        return (CelsiusTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    private Converter getConvertor(final String className) throws IllegalStateException {
        if (className.equals(CelsiusTemperature.class.getName())) {
            return converterCelsiusCelsius;
        } else if (className.equals(KelvinTemperature.class.getName())) {
            return converterCelsiusKelvin;
        } else if (className.equals(NewtonTemperature.class.getName())) {
            return converterCelsiusNewton;
        } else if (className.equals(FahrenheitTemperature.class.getName())) {
            return converterCelsiusFahrenheit;
        } else {
            throw new IllegalStateException("Unexpected value: " + className);
        }
    }
}
