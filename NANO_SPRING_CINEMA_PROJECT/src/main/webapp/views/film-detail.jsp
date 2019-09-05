<%-- 
    Document   : film-detail
    Created on : 05-Sep-2019, 13:48:32
    Author     : HaAnh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Cinema</title>
    </head>
    <body>
        <img src="${film.image}"/>
        <table border="0">
            <tr>
                <td colspan="2">
                    ${film.name}
                </td>
            </tr>
            <tr>
                <td>Time:</td>
                <td>${film.fromDate} - ${film.toDate}</td>
            </tr>
            <tr>
                <td>Category:</td>
                <td></td>
            </tr>
            <tr>
                <td>Actors:</td>
                <td></td>
            </tr>
            <tr>
                <td>Director</td>
                <td></td>
            </tr>
            <tr>
                <td>Duration</td>
                <td>${film.duration}</td>
            </tr>
            <tr>
                <td>Company</td>
                <td></td>
            </tr>
            <c:if test="${current eq true}">
                <tr>
                    <td>
                        <a href="book-ticket/${f.id}">Book Ticket</a>
                    </td>
                </tr>
            </c:if>
        </table>
            <div>
                <h4>Description</h4>
                ${film.description}
            </div>
            <div>
                Trailer
                 <iframe width="420" height="280" src="${film.video}"></iframe> 
            </div>
    </body>
</html>
