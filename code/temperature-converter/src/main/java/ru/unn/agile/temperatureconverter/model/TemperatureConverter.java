package ru.unn.agile.temperatureconverter.model;

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

    @SuppressWarnings("unchecked")
    public <Template extends Temperature> Template convert(
            final Temperature temperature, final Class<Template> target) {
        Converter converterToCelsius = getConverter(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConverter(target.getName());
        return (Template) converterFromCelsius.convertFromCelsius(celsius);
    }

    public void ejsdkj() {
        var a = this.convert(new CelsiusTemperature(1), KelvinTemperature.class);

    }

    public FahrenheitTemperature convertToFahrenheit(final Temperature temperature) {
        Converter converterToCelsius = getConverter(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConverter(FahrenheitTemperature.class.getName());
        return (FahrenheitTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    public KelvinTemperature convertToKelvin(final Temperature temperature) {
        Converter converterToCelsius = getConverter(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConverter(KelvinTemperature.class.getName());
        return (KelvinTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    public NewtonTemperature convertToNewton(final Temperature temperature) {
        Converter converterToCelsius = getConverter(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConverter(NewtonTemperature.class.getName());
        return (NewtonTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    public CelsiusTemperature convertToCelsius(final Temperature temperature) {
        Converter converterToCelsius = getConverter(temperature.getClass().getName());
        CelsiusTemperature celsius = converterToCelsius.convertToCelsius(temperature);
        Converter converterFromCelsius = getConverter(CelsiusTemperature.class.getName());
        return (CelsiusTemperature) converterFromCelsius.convertFromCelsius(celsius);
    }

    private Converter getConverter(final String className) throws IllegalStateException {
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
