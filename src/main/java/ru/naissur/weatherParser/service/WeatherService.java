package ru.naissur.weatherParser.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.naissur.weatherParser.domain.WeatherBean;
import java.util.List;

/**
 * naissur
 * 24.04.2017
 */
public interface WeatherService {
    // Возвращаем разобранный документа
    Document getWeatherInfo();

    // Возвращаем даты как строки вида "1 января"
    String[] getStringDates(Document document);

    /**
     * Создаем объекты WeatherBean, соответствующие всем дням
     * @return список объектов WeatherBean, каждый из которых содержит погоду одного дня
     */
    List<WeatherBean> getWeatherBeans();

    // возвращаем 4 значения погодных условий, соответствующие 4 частям одного дня, по селектору
    String[] getData(Element weatherTable, String selector);

    // возвращаем список реальных температур
    List<String> getRealTemps(Element weatherTable);

    // возвращаем список ощущаемых температур
    List<String> getFeelTemps(Element weatherTable);
}