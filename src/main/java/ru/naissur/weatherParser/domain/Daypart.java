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

    public Daypart(String name, String temperature, String event, String pressure) {
        // TODO пока что каждая часть дня содержит только название, температуру, погодные явления и давление
        // TODO нужно докрутить влажность и ветер
        this.name = name;
        this.temperature = temperature;
        this.event = event;
        this.pressure = pressure;
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

    @Override
    public String toString() {
        return name + ": " + temperature + "; " + event + "; " + pressure;
    }
}
