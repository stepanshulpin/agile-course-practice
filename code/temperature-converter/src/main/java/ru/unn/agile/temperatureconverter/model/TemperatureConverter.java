package ru.unn.agile.temperatureconverter.model;

public class TemperatureConverter {

    private ConverterCelsiusKelvin converterCelsiusKelvin;
    private ConverterCelsiusNewton converterCelsiusNewton;
    private ConverterCelsiusFahrenheit converterCelsiusFahrenheit;

    public TemperatureConverter() {
        converterCelsiusKelvin = new ConverterCelsiusKelvin();
        converterCelsiusNewton = new ConverterCelsiusNewton();
        converterCelsiusFahrenheit = new ConverterCelsiusFahrenheit();
    }

    public FahrenheitTemperature convertToFahrenheit(final CelsiusTemperature celsius) {
        return (FahrenheitTemperature) converterCelsiusFahrenheit.convertFromCelsius(celsius);
    }

    public KelvinTemperature convertToKelvin(final CelsiusTemperature celsius) {
        return (KelvinTemperature) converterCelsiusKelvin.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final CelsiusTemperature celsius) {
        return (NewtonTemperature) converterCelsiusNewton.convertFromCelsius(celsius);
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

    public KelvinTemperature convertToKelvin(final FahrenheitTemperature fahrenheit) {
        CelsiusTemperature celsius = converterCelsiusFahrenheit.convertToCelsius(fahrenheit);
        return (KelvinTemperature) converterCelsiusKelvin.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final FahrenheitTemperature fahrenheit) {
        CelsiusTemperature celsius = converterCelsiusFahrenheit.convertToCelsius(fahrenheit);
        return (NewtonTemperature) converterCelsiusNewton.convertFromCelsius(celsius);
    }

    public FahrenheitTemperature convertToFahrenheit(final KelvinTemperature kelvin) {
        CelsiusTemperature celsius = converterCelsiusKelvin.convertToCelsius(kelvin);
        return (FahrenheitTemperature) converterCelsiusFahrenheit.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final KelvinTemperature kelvin) {
        CelsiusTemperature celsius = converterCelsiusKelvin.convertToCelsius(kelvin);
        return (NewtonTemperature) converterCelsiusNewton.convertFromCelsius(celsius);
    }

    public FahrenheitTemperature convertToFahrenheit(final NewtonTemperature newton) {
        CelsiusTemperature celsius = converterCelsiusNewton.convertToCelsius(newton);
        return (FahrenheitTemperature) converterCelsiusFahrenheit.convertFromCelsius(celsius);
    }

    public KelvinTemperature convertToKelvin(final NewtonTemperature newton) {
        CelsiusTemperature celsius = converterCelsiusNewton.convertToCelsius(newton);
        return (KelvinTemperature) converterCelsiusKelvin.convertFromCelsius(celsius);
    }
}
