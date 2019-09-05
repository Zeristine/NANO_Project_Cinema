<%-- 
    Document   : ticket-price
    Created on : Sep 5, 2019, 3:42:01 PM
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
            .price-list-header{
                float: left;
                width: 100%;
                font-size: 30px;
            }
            .price-list-component{
                float: left;
                width: 95%;
                font-size: 20px;
                margin-top: 10px;
                margin-bottom: 10px;
                margin-left: 10px;
                margin-right: 10px;
            }
            .price-left{
                float: right;
            }
        </style>
    </head>
    <body>
        <div class="price-list-header">
            <b>Ticket Price</b>
        </div>        
        <c:forEach var="p" items="${prices}" >
            <div class="price-list-component">                
                <c:choose>
                    <c:when test="${p.startWeekDay == 1}" >Sun</c:when>
                    <c:when test="${p.startWeekDay == 2}" >Mon</c:when>
                    <c:when test="${p.startWeekDay == 3}" >Tue</c:when>
                    <c:when test="${p.startWeekDay == 4}" >Wed</c:when>
                    <c:when test="${p.startWeekDay == 5}" >Thu</c:when>
                    <c:when test="${p.startWeekDay == 6}" >Fri</c:when>
                    <c:when test="${p.startWeekDay == 7}" >Sat</c:when>
                </c:choose> - 
                <c:choose>
                    <c:when test="${p.endWeekDay == 1}" >Sun</c:when>
                    <c:when test="${p.endWeekDay == 2}" >Mon</c:when>
                    <c:when test="${p.endWeekDay == 3}" >Tue</c:when>
                    <c:when test="${p.endWeekDay == 4}" >Wed</c:when>
                    <c:when test="${p.endWeekDay == 5}" >Thu</c:when>
                    <c:when test="${p.endWeekDay == 6}" >Fri</c:when>
                    <c:when test="${p.endWeekDay == 7}" >Sat</c:when>
                </c:choose> : 
                (${p.startTime}-${p.endTime})
                <div class="price-left" >${p.price} VNĐ/ticket</div>
                <hr/>
            </div>                               
        </c:forEach>                            
    </body>
</html>
