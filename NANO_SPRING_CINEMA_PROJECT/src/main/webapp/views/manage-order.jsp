<%-- 
    Document   : manage-order
    Created on : 06-Sep-2019, 16:16:29
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
        <link rel="stylesheet" href="resources/css/main.css"/>                
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>        
        <script type="text/javascript" src="resources/js/login-register.js"></script>        
    </head>
    <body>
        <div class="header" >
            <div class="left" >
                <button onclick="reload()" >NANO Spring Cinema</button>
            </div>
            <div class="right hide" name="not-logged">
                <a href="form-register" >
                    <button>Register</button>
                </a>
                <a href="form-login">
                    <button>Log in</button>
                </a>                
                <a href="ticket-price">
                    <button class="">Ticket Price</button>                
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
                <a href="ticket-price">
                    <button class="">Ticket Price</button>                
                </a>                
            </div>
        </div>        
        <h1>Manage Orders</h1>
        <c:if test="${not empty orders}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Film</th>
                        <th>Order date</th>
                        <!--<th>Total price</th>-->
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>
                                ${order.showTime.film.name}
                            </td>
                            <td>
                                ${order.orderDate}
                            </td>

                            <td>
                                <c:choose>
                                    <c:when test="${order.status eq -1}">
                                        <p style="color: red;">Canceled</p>
                                    </c:when>
                                    <c:when test="${order.status eq 0 or empty order.status}">
                                        <form action="cancel-order" method="POST">
                                            <input type="hidden" name="id" value="${order.id}" />
                                            <input type="hidden" name="accountId" value="${account.id}" />
                                            <input type="submit" value="Cancel Order" />
                                        </form>
                                    </c:when>
                                    <c:when test="${order.status eq 1}">Received</c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty orders}">
            No orders found.
        </c:if>
    </body>
</html>
