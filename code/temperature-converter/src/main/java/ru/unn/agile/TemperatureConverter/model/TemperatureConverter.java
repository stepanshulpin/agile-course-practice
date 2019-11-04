package ru.unn.agile.TemperatureConverter.model;

public class TemperatureConverter {
    public FahrenheitTemperature convertToFahrenheit(final CelsiusTemperature celsius) {
        ConverterCelsiusFahrenheit converter = new ConverterCelsiusFahrenheit();
        return converter.convertToFahrenheit(celsius);
    }

    public KelvinTemperature convertToKelvin(final CelsiusTemperature celsius) {
        ConverterCelsiusKelvin converter = new ConverterCelsiusKelvin();
        return converter.convertToKelvin(celsius);
    }

    public NewtonTemperature convertToNewton(final CelsiusTemperature celsius) {
        ConverterCelsiusNewton converter = new ConverterCelsiusNewton();
        return converter.convertToNewton(celsius);
    }

    public CelsiusTemperature convertToCelsius(final FahrenheitTemperature fahrenheit) {
        ConverterCelsiusFahrenheit converter = new ConverterCelsiusFahrenheit();
        return converter.convertToCelsius(fahrenheit);
    }

    public KelvinTemperature convertToKelvin(final FahrenheitTemperature fahrenheit) {
        final CelsiusTemperature celsius = convertToCelsius(fahrenheit);
        return convertToKelvin(celsius);
    }

    public NewtonTemperature convertToNewton(final FahrenheitTemperature fahrenheit) {
        final CelsiusTemperature celsius = convertToCelsius(fahrenheit);
        return convertToNewton(celsius);
    }

    public CelsiusTemperature convertToCelsius(final KelvinTemperature kelvin) {
        ConverterCelsiusKelvin converter = new ConverterCelsiusKelvin();
        return converter.convertToCelsius(kelvin);
    }

    public FahrenheitTemperature convertToFahrenheit(final KelvinTemperature kelvin) {
        final CelsiusTemperature celsius = convertToCelsius(kelvin);
        return convertToFahrenheit(celsius);
    }

    public NewtonTemperature convertToNewton(final KelvinTemperature kelvin) {
        final CelsiusTemperature celsius = convertToCelsius(kelvin);
        return convertToNewton(celsius);
    }

    public CelsiusTemperature convertToCelsius(final NewtonTemperature newton) {
        ConverterCelsiusNewton converter = new ConverterCelsiusNewton();
        return converter.convertToCelsius(newton);
    }

    public FahrenheitTemperature convertToFahrenheit(final NewtonTemperature newton) {
        final CelsiusTemperature celsius = convertToCelsius(newton);
        return convertToFahrenheit(celsius);
    }

    public KelvinTemperature convertToKelvin(final NewtonTemperature newton) {
        final CelsiusTemperature celsius = convertToCelsius(newton);
        return convertToKelvin(celsius);
    }
}
