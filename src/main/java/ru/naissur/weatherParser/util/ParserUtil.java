package ru.naissur.weatherParser.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * naissur
 * 24.04.2017
 */
public class ParserUtil {
    public static Elements getWeaterTables(Document document) {
        return document.select("tbody[class=weather-table__body]");
    }

    /**
     * Возвращаем список дат в формате "1 января"
     * @param dateElements Массив объектов Elements, из которого необходимо достать даты
     * @return список с датами в нужном формате
     */
    public static List<String> getStringDates (Elements dateElements) {
        List<String> dates = new ArrayList<>();

        for (Element dateElement : dateElements) {
            String date = dateElement.select("strong[class=forecast-detailed__day-number]").first().text();

            // нужно отрезать от строки слова "сегодня" или "завтра"
            if (date.endsWith("сегодня")) {
                date = date.substring(0, date.indexOf("сегодня"));
            } else if (date.endsWith("завтра")) {
                date = date.substring(0, date.indexOf("завтра"));
            }

            dates.add(date);
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
}
