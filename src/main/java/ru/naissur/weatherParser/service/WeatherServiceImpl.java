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
    private Document document; // разобранная страница
    private Elements weatherTables; // вытащенные из html таблицы с погодой каждого дня

    // инициализируем document и weatherTables
    public WeatherServiceImpl() {
        document = getWeatherInfo();
        weatherTables = ParserUtil.getWeaterTables(document);
    }

    @Override
    public List<String> getStringDates(Document document) {
        return ParserUtil.getStringDates(document);
    }

    @Override
    public List<String> getData(Element weatherTable, String selector) {
        return ParserUtil.getData(weatherTable, selector);
    }

    @Override
    public Document getWeatherInfo() {
        return ParserUtil.getWeatherInfo();
    }

    @Override
    public List<String> getRealTemps(Element weatherTable) {
        return ParserUtil.getRealTemps(weatherTable);
    }

    @Override
    public List<String> getFeelTemps(Element weatherTable) {
        return ParserUtil.getFeelTemps(weatherTable);
    }

    @Override
    public List<WeatherBean> getWeatherBeans() {
        List<WeatherBean> weatherBeans = new ArrayList<>();

        List<String> dates = getStringDates(document); // список дат

        for (int i = 0; i < weatherTables.size(); i++) {
            Element weatherTable = weatherTables.get(i);

            List<String> realTemps = getRealTemps(weatherTable); // реальная температура
            List<String> feelTemps = getFeelTemps(weatherTable); // ощущаемая температура
            List<String> names = getData(weatherTable, ParserUtil.DAYPART_NAMES); // названия частей дня
            List<String> events = getData(weatherTable, ParserUtil.EVENTS); // погодные явления дня
            List<String> pressures = getData(weatherTable, ParserUtil.PRESSURES); // значения давлений дня
            List<String> humidities = getData(weatherTable, ParserUtil.HUMIDITIES); // значения влажности

            Elements windsDirections = weatherTable.select("abbr[class=icon-abbr]");
            Elements windSpeeds = weatherTable.select("span[class=wind-speed]");
            Daypart[] beanDayparts = new Daypart[4];
            for (int j = 0; j < 4; j++) {
                beanDayparts[j] = new Daypart(names.get(j), realTemps.get(j), events.get(j), pressures.get(j), humidities.get(j),
                        windsDirections.remove(0).text() + " " + windSpeeds.remove(0).text(), feelTemps.get(j));
            }

            weatherBeans.add(new WeatherBean(dates.get(i), beanDayparts));
        }

        System.out.println(weatherBeans);
        return weatherBeans;
    }
}