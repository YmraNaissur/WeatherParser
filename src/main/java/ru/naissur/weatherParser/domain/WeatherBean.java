package ru.naissur.weatherParser.domain;

import java.util.Arrays;

/**
 * naissur
 * 24.04.2017
 * Класс отображает погоду одного дня, соответствующего полю date
 * Каждый день состоит из 4 частей: утро, день, вечер и ночь.
 * Эти 4 части дня содержатся в массиве объектов Daypart.
 */
public class WeatherBean {
    private String date;
    private Daypart[] dayparts;

    public WeatherBean(String date, Daypart[] daypart) {
        this.date = date;
        this.dayparts = daypart;
    }

    public String getDate() {
        return date;
    }

    public Daypart[] getDayparts() {
        return dayparts;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "date='" + date + '\'' +
                ", dayparts=" + Arrays.toString(dayparts) +
                '}';
    }
}
