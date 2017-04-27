<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="weatherBeans" type="java.util.List" scope="request" />

<html>
    <body>
        <h2>Forecast</h2>

        <table border="1">
            <tr>
                <th>Дата</th>
                <th>Время суток</th>
                <th>Температура</th>
                <th>Погодные явления</th>
                <th>Давление, мм. рт. ст.</th>
                <th>Влажность</th>
                <th>Ветер, м/c</th>
                <th>Как ощущается</th>
            </tr>
            <c:forEach items="${weatherBeans}" var="bean">
                <tr>
                    <td rowspan="5">${bean.date}</td>
                </tr>
                <c:forEach items="${bean.dayparts}" var="beanDaypart">
                    <tr>
                        <td>${beanDaypart.name}</td>
                        <td>${beanDaypart.realTemperature}</td>
                        <td>${beanDaypart.event}</td>
                        <td>${beanDaypart.pressure}</td>
                        <td>${beanDaypart.humidity}</td>
                        <td>${beanDaypart.wind}</td>
                        <td>${beanDaypart.feelTemperature}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </body>
</html>
