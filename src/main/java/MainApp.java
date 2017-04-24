import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.naissur.weatherParser.service.WeatherServiceImpl;
import ru.naissur.weatherParser.util.ParserUtil;

/**
 * naissur
 * 24.04.2017
 */
public class MainApp {
    public static void main(String[] args) {
        /*Document document = ParserUtil.getWeatherInfo();
        Elements weatherTables = ParserUtil.getWeaterTables(document);

        for (Element table : weatherTables) {
            System.out.println("Part of day: " + table.select("div[class=weather-table__daypart]").text());
            System.out.println("Temperature: " + table.select("div[class=weather-table__temp]").text());
        }*/

        new WeatherServiceImpl().getWeatherBeans();
    }
}