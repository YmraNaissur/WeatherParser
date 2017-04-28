package ru.naissur.weatherParser.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * naissur
 * 24.04.2017
 */
public class ParserUtil {
    // приватные константы не используются за пределами ParserUtil
    private static final String DATES = "strong[class=forecast-detailed__day-number]";
    private static final String TEMPS = "div[class=weather-table__temp]";

    public static final String WIND_DIRECTIONS = "abbr[class=icon-abbr]";
    public static final String WIND_SPEEDS = "span[class=wind-speed]";
    public static final String DAYPART_NAMES = "div[class=weather-table__daypart]";
    public static final String EVENTS = "td[class=weather-table__body-cell weather-table__body-cell_type_condition]";
    public static final String PRESSURES = "td[class=weather-table__body-cell weather-table__body-cell_type_air-pressure]";
    public static final String HUMIDITIES = "td[class=weather-table__body-cell weather-table__body-cell_type_humidity]";

    public static Elements getWeaterTables(Document document) {
        return document.select("tbody[class=weather-table__body]");
    }

    /**
     * Возвращаем список значений погодных условий одного дня по селектору
     * @param weatherTable объект Element, содержащий данные по всем погодным условиям одного дня
     * @param selector строка, обозначающая, что из погодных условий мы хотим извлечь (events, pressures, humidity...)
     * @return список значений погодных условий, соответствующих 4 частям дня
     */
    public static String[] getData(Element weatherTable, String selector) {
        String[] stringData = new String[4];

        Elements dataElements = weatherTable.select(selector);
        for (int i = 0; i < stringData.length; i++) {
            stringData[i] = dataElements.get(i).text();
        }

        return stringData;
    }

    /**
     * Возвращаем список дат в формате "1 января"
     * @param document разобранный html, из которого необходимо достать даты
     * @return список с датами в нужном формате
     */
    public static String[] getStringDates (Document document) {
        String[] dates = new String[4];

        Elements dateElements = document.select(DATES);
        for (int i = 0; i < dates.length; i++) {
            String date = dateElements.get(i).select("strong[class=forecast-detailed__day-number]").first().text();

            // нужно отрезать от строки слова "сегодня" или "завтра"
            if (date.endsWith("сегодня")) {
                date = date.substring(0, date.indexOf("сегодня"));
            } else if (date.endsWith("завтра")) {
                date = date.substring(0, date.indexOf("завтра"));
            }

            dates[i] = date;
        }

        return dates;
    }

    /**
     * Получаем разобранную Jsoup'ом страницу
     * @return Объект Document, содержащий разобранную страницу
     */
    public static Document getWeatherInfo() {
        try {
            String URL_ADDRESS = "https://yandex.ru/pogoda/saint-petersburg/details";
            URL url = new URL(URL_ADDRESS);
            return Jsoup.parse(url, 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Получить список реальных температур
     * @param weatherTable таблица погоды дня
     * @return список реальных температур
     */
    public static List<String> getRealTemps(Element weatherTable) {
        List<String> temps = Arrays.asList(getData(weatherTable, TEMPS)); // список всех температур
        // в списке temps реальные температуры находятся на четных индексах
        return temps
                .stream()
                .filter(t -> temps.indexOf(t) % 2 == 0)
                .collect(Collectors.toList());
    }

    /**
     * Получить список температур, как они ощущаются с учетом погодных условий
     * @param weatherTable таблица погоды дня
     * @return список ощущаемых температур
     */
    public static List<String> getFeelTemps(Element weatherTable) {
        List<String> temps = Arrays.asList(getData(weatherTable, TEMPS)); // список всех температур
        // в списке temps ощущаемые температуры находятся на нечетных индексах
        return temps
                .stream()
                .filter(t -> temps.indexOf(t) % 2 != 0)
                .collect(Collectors.toList());
    }
}