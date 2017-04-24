package ru.naissur.weatherParser.service;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.naissur.weatherParser.util.ParserUtil;

import java.util.List;

/**
 * naissur
 * 24.04.2017
 */
public class WeatherServiceImpl implements WeatherService {
    @Override
    public List<String> getStringDates(Elements dateElements) {
        return ParserUtil.getStringDates(dateElements);
    }

    @Override
    public Document getWeatherInfo() {
        return ParserUtil.getWeatherInfo();
    }
}
