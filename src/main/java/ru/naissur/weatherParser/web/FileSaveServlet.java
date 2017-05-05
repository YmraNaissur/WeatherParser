package ru.naissur.weatherParser.web;

import ru.naissur.weatherParser.service.WeatherService;
import ru.naissur.weatherParser.service.WeatherServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * naissur
 * 28.04.2017
 * Здесь выполняем действия, необходимые для сохранения данных в файл
 */
public class FileSaveServlet extends HttpServlet {
    private WeatherService weatherService;

    @Override
    public void init() throws ServletException {
        super.init();
        weatherService = new WeatherServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Saving the file to " + req.getParameter("filePath"));

        weatherService.saveToTextFile(weatherService.getWeatherBeans(), req.getParameter("filePath"));

        resp.sendRedirect("weather");
    }
}