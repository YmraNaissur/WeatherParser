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
    public String[] getStringDates(Document document) {
        return ParserUtil.getStringDates(document);
    }

    @Override
    public String[] getData(Element weatherTable, String selector) {
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

        String[] dates = getStringDates(document); // список дат

        for (int i = 0; i < weatherTables.size(); i++) {
            Element weatherTable = weatherTables.get(i);

            List<String> realTemps = getRealTemps(weatherTable); // реальная температура
            List<String> feelTemps = getFeelTemps(weatherTable); // ощущаемая температура
            String[] names = getData(weatherTable, ParserUtil.DAYPART_NAMES); // названия частей дня
            String[] events = getData(weatherTable, ParserUtil.EVENTS); // погодные явления дня
            String[] pressures = getData(weatherTable, ParserUtil.PRESSURES); // значения давлений дня
            String[] humidities = getData(weatherTable, ParserUtil.HUMIDITIES); // значения влажности
            String[] windDirections = getData(weatherTable, ParserUtil.WIND_DIRECTIONS); // направления ветра
            String[] windSpeeds = getData(weatherTable, ParserUtil.WIND_SPEEDS); // скорости ветра

            Daypart[] beanDayparts = new Daypart[4];
            for (int j = 0; j < 4; j++) {
                beanDayparts[j] = new Daypart(names[j], realTemps.get(j), events[j], pressures[j], humidities[j],
                        windDirections[j] + " " + windSpeeds[j], feelTemps.get(j));
            }

            // формируем объект WeatherBean и заносим его в список
            weatherBeans.add(new WeatherBean(dates[i], beanDayparts));
        }

        return weatherBeans;
    }
}