package ru.naissur.weatherParser.service;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.naissur.weatherParser.domain.WeatherBean;

import java.util.List;

/**
 * naissur
 * 24.04.2017
 */
public interface WeatherService {
    List<String> getStringDates(Elements dateElements);
    Document getWeatherInfo();
    List<WeatherBean> getWeatherBeans();
}
