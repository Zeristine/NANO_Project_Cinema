<%-- 
    Document   : order-book-phase-1
    Created on : Sep 5, 2019, 3:42:17 PM
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
            table td{
                width: 50%;
            }
            table select{
                width: 100%;
                height: 75px;
                font-weight: bold;
            }
            table button{
                width: 100%;
            }            
        </style>
    </head>
    <body>
        <table border="0">            
            <tbody>
                <tr>
                    <th>Film</th>
                    <th>Showing Date</th>                    
                </tr>
                <tr>
                    <td>
                        <select name="film" onchange="openOrCloseShowTimeSelect(this)" >
                            <option value="0" >Select a film</option>
                            <c:forEach var="f" items="${films}" >
                                <option value="${f.id}"  >${f.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td name="st">
                        <select name="st" disabled onchange="openOrCloseChooseSeat(this)" >
                            <option value="0" >Select the showing date</option>                            
                        </select>
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <button onclick="clearAllOrder()" >
                            Cancel
                        </button>
                    </td>
                    <td>
                        <button onclick="toRoomPhase()" disabled name="button-seat">
                            Choose Seat
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
