package ru.unn.agile.TemperatureConverter.model;

public class DegreeCelsius {
    private double temperature;
    private final double absoluteZero = -273.15;

    public DegreeCelsius(final double temperature) throws IllegalArgumentException{
        if(temperature < this.absoluteZero){
            throw new IllegalArgumentException("The temperature is less than absolute zero!");
        }
        this.temperature = temperature;
    }

    public double getTemperature() {
        return this.temperature;
    }
}
