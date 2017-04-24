package ru.naissur.weatherParser.service;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.List;

/**
 * naissur
 * 24.04.2017
 */
public interface WeatherService {
    List<String> getStringDates (Elements dateElements);
    Document getWeatherInfo();
}
