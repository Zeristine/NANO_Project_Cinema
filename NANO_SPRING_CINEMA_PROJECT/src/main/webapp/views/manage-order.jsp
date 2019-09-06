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
    </head>
    <body>
        <h1>Manage Orders</h1>
        <c:if test="${not empty orders}">
            <table border="0">
                <thead>
                    <tr>
                        <th>Film</th>
                        <th>Order date</th>
                        <th>Total price</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>
                                ${order.showTime.Film.name}
                            </td>
                            <td>
                                ${order.orderDate}
                            </td>
                            <td>
                                ${order.totalPrice}
                            </td>
                            <td>
                                ${order.status}
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
