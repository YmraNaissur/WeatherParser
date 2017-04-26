package ru.naissur.weatherParser.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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

    /**
     * Создаем объекты WeatherBean, соответствующие всем дням
     * @return список объектов WeatherBean, каждый из которых содержит погоду одного дня
     */
    List<WeatherBean> getWeatherBeans();

    // возвращаем 4 значения погодных условий, соответствующие 4 частям одного дня, по селектору
    List<String> getData(Element weatherTable, String selector);
}