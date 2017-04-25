package ru.naissur.weatherParser.domain;

/**
 * naissur
 * 24.04.2017
 * Класс описывает часть дня: утро, день, вечер и ночь.
 * У каждой части дня своя погода: температура, погодные явления, давление, влажность, ветер
 */
public class Daypart {
    private String name; // утро, день, вечер, ночь
    private String temperature; // температура
    private String event; // погодное явление
    private String pressure; // давление
    private String humidity; // влажность
    private String wind; // ветер

    public Daypart(String name, String temperature, String event, String pressure, String humidity, String wind) {
        this.name = name;
        this.temperature = temperature;
        this.event = event;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getEvent() {
        return event;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return name + ": " + temperature + "; " + event + "; " + pressure + "; " + humidity;
    }
}
