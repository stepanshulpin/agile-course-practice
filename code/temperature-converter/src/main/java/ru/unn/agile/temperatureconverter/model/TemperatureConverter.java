package ru.unn.agile.temperatureconverter.model;

import java.util.HashMap;
import java.util.Map;

public class TemperatureConverter {

    private ConverterCelsiusCelsius converterCelsiusCelsius;
    private ConverterCelsiusKelvin converterCelsiusKelvin;
    private ConverterCelsiusNewton converterCelsiusNewton;
    private ConverterCelsiusFahrenheit converterCelsiusFahrenheit;
    private Map<String, Converter> converterDictionary;

    public TemperatureConverter() {
        converterCelsiusCelsius = new ConverterCelsiusCelsius();
        converterCelsiusKelvin = new ConverterCelsiusKelvin();
        converterCelsiusNewton = new ConverterCelsiusNewton();
        converterCelsiusFahrenheit = new ConverterCelsiusFahrenheit();

        converterDictionary = new HashMap<>();
        converterDictionary.put("ru.unn.agile.temperatureconverter.model.CelsiusTemperature",
                                converterCelsiusCelsius);
        converterDictionary.put("ru.unn.agile.temperatureconverter.model.KelvinTemperature",
                                converterCelsiusKelvin);
        converterDictionary.put("ru.unn.agile.temperatureconverter.model.NewtonTemperature",
                                converterCelsiusNewton);
        converterDictionary.put("ru.unn.agile.temperatureconverter.model.FahrenheitTemperature",
                                converterCelsiusFahrenheit);
    }

    public FahrenheitTemperature convertToFahrenheit(final Temperature temperature) {
        Converter converterToCelsius = converterDictionary.get(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);

        Converter converterToFahrenheit = converterDictionary.get(
                "ru.unn.agile.temperatureconverter.model.FahrenheitTemperature");
        return (FahrenheitTemperature) converterToFahrenheit.convertFromCelsius(celsius);
    }

    public KelvinTemperature convertToKelvin(final Temperature temperature) {
        Converter converterToCelsius = converterDictionary.get(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);

        Converter converterToKelvin = converterDictionary.get(
                "ru.unn.agile.temperatureconverter.model.KelvinTemperature");
        return (KelvinTemperature) converterToKelvin.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final Temperature temperature) {
        Converter converterToCelsius = converterDictionary.get(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);

        Converter convertToNewton = converterDictionary.get(
                "ru.unn.agile.temperatureconverter.model.NewtonTemperature");
        return (NewtonTemperature) convertToNewton.convertFromCelsius(celsius);
    }

    public CelsiusTemperature convertToCelsius(final FahrenheitTemperature fahrenheit) {
        return converterCelsiusFahrenheit.convertToCelsius(fahrenheit);
    }

    public CelsiusTemperature convertToCelsius(final KelvinTemperature kelvin) {
        return converterCelsiusKelvin.convertToCelsius(kelvin);
    }

    public CelsiusTemperature convertToCelsius(final NewtonTemperature newton) {
        return converterCelsiusNewton.convertToCelsius(newton);
    }

    public NewtonTemperature convertToNewton(final FahrenheitTemperature fahrenheit) {
        CelsiusTemperature celsius = converterCelsiusFahrenheit.convertToCelsius(fahrenheit);
        return (NewtonTemperature) converterCelsiusNewton.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final KelvinTemperature kelvin) {
        CelsiusTemperature celsius = converterCelsiusKelvin.convertToCelsius(kelvin);
        return (NewtonTemperature) converterCelsiusNewton.convertFromCelsius(celsius);
    }
}
