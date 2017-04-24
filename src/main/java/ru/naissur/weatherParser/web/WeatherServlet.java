package ru.naissur.weatherParser.web;

import org.jsoup.select.Elements;
import ru.naissur.weatherParser.service.WeatherService;
import ru.naissur.weatherParser.service.WeatherServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * naissur
 * 24.04.2017
 */
public class WeatherServlet extends HttpServlet {
    private WeatherService weatherService;

    @Override
    public void init() throws ServletException {
        super.init();
        weatherService = new WeatherServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Elements dates = weatherService.getWeatherInfo().select("strong[class=forecast-detailed__day-number]");
        req.setAttribute("dates", weatherService.getStringDates(dates));
        // форвардим информацию JSP-странице для отображения
        req.getRequestDispatcher("/weather.jsp").forward(req, resp);
    }
}
