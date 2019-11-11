<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Dynamics</title>
    </head>

    <body>
        <c:forEach var="genre" items="${requestScope.genres}">
            <p style="font-weight: 600">${genre}</p>
            <table cellpadding="3px">
                <tr>
                    <td></td>
                    <td>2017</td>
                    <td>2018</td>
                    <td>2019</td>
                </tr>
                <tr>
                    <td>USA</td>
                    <td>${requestScope.american_2017[genre]}</td>
                    <td>${requestScope.american_2018[genre]}</td>
                    <td>${requestScope.american_2019[genre]}</td>
                </tr>
                <tr>
                    <td>China</td>
                    <td>${requestScope.chinese_2017[genre]}</td>
                    <td>${requestScope.chinese_2018[genre]}</td>
                    <td>${requestScope.chinese_2019[genre]}</td>
                </tr>
            </table>
        </c:forEach>
        <p style="font-weight: 600">Sources:</p>
        American movies:
        <ul>
            <li>https://en.wikipedia.org/w/index.php?title=List_of_American_films_of_2017&oldid=925576219</li>
            <li>https://en.wikipedia.org/w/index.php?title=List_of_American_films_of_2018&oldid=925576149</li>
            <li>https://en.wikipedia.org/w/index.php?title=List_of_American_films_of_2019&oldid=925616104</li>
        </ul>

        Chinese movies:
        <ul>
            <li>https://en.wikipedia.org/w/index.php?title=List_of_Chinese_films_of_2017&oldid=923009452</li>
            <li>https://en.wikipedia.org/w/index.php?title=List_of_Chinese_films_of_2018&oldid=900037799</li>
            <li>https://en.wikipedia.org/w/index.php?title=List_of_Chinese_films_of_2019&oldid=925625488</li>
        </ul>
    </body>
</html>