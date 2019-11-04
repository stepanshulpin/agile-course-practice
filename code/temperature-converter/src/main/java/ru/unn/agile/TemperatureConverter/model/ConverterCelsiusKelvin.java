package ru.unn.agile.TemperatureConverter.model;

class ConverterCelsiusKelvin {
    CelsiusTemperature convertToCelsius(final KelvinTemperature kelvin) {
        final double shift = 273.15;
        return new CelsiusTemperature(kelvin.getValue() - shift);
    }

    KelvinTemperature convertToKelvin(final CelsiusTemperature celsius) {
        final double shift =  273.15;
        return new KelvinTemperature(celsius.getValue() + shift);
    }
}
