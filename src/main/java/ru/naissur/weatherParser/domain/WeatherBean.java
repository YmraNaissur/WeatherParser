package ru.naissur.weatherParser.domain;

import java.util.Arrays;

/**
 * naissur
 * 24.04.2017
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
