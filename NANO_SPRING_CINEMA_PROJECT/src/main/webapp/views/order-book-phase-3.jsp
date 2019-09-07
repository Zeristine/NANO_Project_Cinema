<%-- 
    Document   : order-book-phase-3
    Created on : Sep 6, 2019, 10:53:19 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                width: 100%;
            }
            table img{
                width: 150px;
                height: 200px;
            }
        </style>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Confirm booking Order</th>                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="4" >
                        <img src="${showtime.film.image}" />
                    </td>
                    <th>${showtime.film.name}</th>
                </tr>
                <tr>
                    <td>Aired at ${showtime.showDate}</td>                    
                </tr>
                <tr>
                    <td>At Room ${showtime.room.id}</td>                    
                </tr>                
                <tr>
                    <td>Seats:
                        <c:forTokens var="seat" items="${seats}" delims="|" >
                            ${seat} 
                        </c:forTokens>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button onclick="backToPrevious()">Choosing Seat</button>
                        <button onclick="clearAllOrder()" >Cancel</button>
                        <button onclick="bookOrder()">Confirm</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
