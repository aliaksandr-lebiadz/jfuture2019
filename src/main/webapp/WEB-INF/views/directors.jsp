<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Top directors</title>
    </head>

    <body>
        <table cellpadding="3px">
            <tr>
                <td></td>
                <td>Title</td>
                <td>Director</td>
                <td>Rating</td>
            </tr>
            <c:forEach var="movie" items="${requestScope.movies}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.rating}</td>
                </tr>
            </c:forEach>
        </table>
    <p style="font-weight: 600">Source:</p>
    https://www.imdb.com/chart/top
</html>