<%-- 
    Document   : film-list
    Created on : Sep 5, 2019, 9:56:38 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Cinema</title>
        <style>
            div[name=film]{
                float: left;
                width: 150px;
                height: 200px;
                margin: 5px 10px;
            }

            div[name=film] img{
                width: 100%;
                height: 150px;
            }
            div[name=title]{
                width: 100%;
                height: 50px;
            }
        </style>
    </head>
    <body>
        <form action="search-film" method="POST">
            <input type="text" name="name" value="" placeholder="Search film" />
            <input type="submit" value="Search" />
        </form>
        <c:if test="${not empty films}">
            <c:forEach var="f" items="${films}">
                <div name="film">
                    <img src="${f.image}"/>
                    <div name="title" >
                        <h3>${f.name}</h3>
                    </div>
                    <ul>
                        <li>Category: </li>
                        <li>Duration: ${f.duration}</li>
                        <li>Start Date: ${f.fromDate}</li>
                    </ul>
                    <c:if test="${current eq true}">
                        <a href="book-ticket/${f.id}">Book Ticket</a>
                    </c:if>
                    <form action="film-detail" method="POST">
                        <input type="hidden" name="id" value="${f.id}" />
                        <input type="submit" value="View Detail" />
                    </form>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${not empty toBeOutFilms}">
            <c:forEach var="f" items="${toBeOutFilms}">
                <div name="film">
                    <img src="${f.image}"/>
                    <div name="title" >
                        <h3>${f.name}</h3>
                    </div>
                    <ul>
                        <li>Category: </li>
                        <li>Duration: ${f.duration}</li>
                        <li>Start Date: ${f.fromDate}</li>
                    </ul>
                    <form action="film-detail" method="POST">
                        <input type="hidden" name="id" value="${f.id}" />
                        <input type="submit" value="View Detail" />
                    </form>
                </div>
            </c:forEach>
        </c:if>
    </body>
</html>
