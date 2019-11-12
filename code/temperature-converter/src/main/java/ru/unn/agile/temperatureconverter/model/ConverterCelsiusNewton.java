package ru.unn.agile.temperatureconverter.model;

class ConverterCelsiusNewton {
    CelsiusTemperature convertToCelsius(final NewtonTemperature newton) {
        final double coefficient = 100.0 / 33.0;
        return new CelsiusTemperature(coefficient * newton.getValue());
    }

    NewtonTemperature convertToNewton(final CelsiusTemperature celsius) {
        final double coefficient = 33.0 / 100.0;
        return new NewtonTemperature(coefficient * celsius.getValue());
    }
}
