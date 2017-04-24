<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <h2>Forecast</h2>

        <table border="1">
            <tr>
                <c:forEach items="${dates}" var="date">
                    <td>${date}</td>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>
