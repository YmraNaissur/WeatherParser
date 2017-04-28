package ru.naissur.weatherParser.web;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Saving the file to " + req.getParameter("filePath"));
        resp.sendRedirect("weather");
    }
}