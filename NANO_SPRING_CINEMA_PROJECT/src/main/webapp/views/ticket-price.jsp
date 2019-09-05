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
        <title>Ticket Price - Spring Cinema</title>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/login-register.js"></script>
        <script type="text/javascript" src="resources/js/main.js"></script>
        <link rel="stylesheet" href="resources/css/main.css"/>
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
        <div class="header" >
            <div class="left" >
                <button onclick="backToHome()" >NANO Spring Cinema</button>
            </div>
            <div class="right hide" name="not-logged">
                <a href="form-register" >
                    <button>Register</button>
                </a>
                <a href="form-login">
                    <button>Log in</button>
                </a>
                <a href="form-order">
                    <button class="">Book Ticket</button>                
                </a>                
                <a href="#">
                    <button class="active" >Ticket Price</button>                
                </a>
            </div>
            <div class="right hide" name="logged">
                <button onclick="logout()" >Log out</button>           
                <a name="logged-link">
                    <button name="logged"></button>    
                </a>
                <a href="form-order">
                    <button class="">Book Ticket</button>                
                </a>                
                <a href="#">
                    <button class="active" >Ticket Price</button>                
                </a>
            </div>
        </div>        
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
