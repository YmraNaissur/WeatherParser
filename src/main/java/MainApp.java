import ru.naissur.weatherParser.service.WeatherService;
import ru.naissur.weatherParser.service.WeatherServiceImpl;

import java.io.IOException;

/**
 * naissur
 * 24.04.2017
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        WeatherService weatherService = new WeatherServiceImpl();
        System.out.println(weatherService.getWeatherBeans());
    }
}