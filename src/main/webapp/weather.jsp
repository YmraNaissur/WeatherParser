<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <h2>Forecast</h2>

        <table border="1">
                <c:forEach items="${weatherBeans}" var="bean">
                    <tr>
                        <td rowspan="5">${bean.date}</td>
                    </tr>
                    <c:forEach items="${bean.dayparts}" var="beanDaypart">
                        <tr>
                            <td>${beanDaypart.name}</td>
                            <td>${beanDaypart.temperature}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>
