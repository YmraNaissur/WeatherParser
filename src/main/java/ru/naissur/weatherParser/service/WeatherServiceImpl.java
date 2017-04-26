package ru.naissur.weatherParser.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.naissur.weatherParser.domain.Daypart;
import ru.naissur.weatherParser.domain.WeatherBean;
import ru.naissur.weatherParser.util.ParserUtil;
import java.util.ArrayList;
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

    public List<String> getStringEvents(Element weatherTable) {
        return ParserUtil.getStringEvents(weatherTable);
    }

    @Override
    public Document getWeatherInfo() {
        return ParserUtil.getWeatherInfo();
    }

    @Override
    public List<WeatherBean> getWeatherBeans() {
        List<WeatherBean> weatherBeans = new ArrayList<>();

        Document document = getWeatherInfo();
        Elements weatherTables = ParserUtil.getWeaterTables(document);
        List<String> dates = getStringDates(document.select("strong[class=forecast-detailed__day-number]"));

        for (int i = 0; i < weatherTables.size(); i++) {
            Element weatherTable = weatherTables.get(i);
            String[] names = weatherTable.select("div[class=weather-table__daypart").text().split(" ");
            String[] temps = weatherTable.select("div[class=weather-table__temp]").text().split(" [+−]?\\d\\s?");

            List<String> events = getStringEvents(weatherTable);
            Elements pressures = weatherTable.select("td[class=weather-table__body-cell weather-table__body-cell_type_air-pressure]");
            Elements humidities = weatherTable.select("td[class=weather-table__body-cell weather-table__body-cell_type_humidity]");
            Elements windsDirections = weatherTable.select("abbr[class=icon-abbr]");
            Elements windSpeeds = weatherTable.select("span[class=wind-speed]");
            Daypart[] beanDayparts = new Daypart[4];
            for (int j = 0; j < 4; j++) {
                beanDayparts[j] = new Daypart(names[j], temps[j], events.get(j),
                        pressures.remove(0).text(), humidities.remove(0).text(), windsDirections.remove(0).text() + " " + windSpeeds.remove(0).text());
            }

            weatherBeans.add(new WeatherBean(dates.get(i), beanDayparts));
        }

        System.out.println(weatherBeans);
        return weatherBeans;
    }
}