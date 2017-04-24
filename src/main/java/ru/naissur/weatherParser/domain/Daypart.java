package ru.naissur.weatherParser.domain;

/**
 * naissur
 * 24.04.2017
 * Класс описывает часть дня: утро, день, вечер и ночь.
 * У каждой части дня своя погода: температура, погодные явления, давление, влажность, ветер
 */
public class Daypart {
    private String name; // утро, день, вечер, ночь
    private String temperature;

    public Daypart(String name, String temperature) {
        // TODO пока что каждая часть дня содержит только название и температуру
        // TODO нужно докрутить явления, давление, влажность, ветер
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return name + ": " + temperature + "; ";
    }
}
