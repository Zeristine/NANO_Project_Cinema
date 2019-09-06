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
                    <th colspan="2" >Film</th>
                    <th colspan="2" >Showing Date</th>
                    <th colspan="2" >Showing Time</th>
                </tr>
                <tr>
                    <td colspan="2" >
                        <select name="film" onchange="openOrCloseShowDateSelect(this)" >
                            <option value="0" >Select a film</option>
                            <c:forEach var="f" items="${films}" >
                                <option value="1" >${f.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td colspan="2" >
                        <select name="date" disabled onchange="openOrCloseTimeDateSelect(this)" >
                            <option value="0" >Select the showing date</option>
                            <option value="1">2019-09-10</option>
                            <option value="2">2019-09-11</option>
                            <option value="3">2019-09-12</option>
                            <option value="4">2019-09-13</option>
                            <option value="5">2019-09-14</option>
                        </select>
                    </td>
                    <td colspan="2" >
                        <select name="time" disabled onclick="openOrCloseChooseSeat(this)" >
                            <option value="0" >Select the show time</option>
                            <c:forEach var="tt" items="${timetables}" >
                                <option value="${tt.id}" >${tt.startTime}-${tt.endTime}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" >
                        <button onclick="clearAllOrder()" >
                            Cancel
                        </button>
                    </td>
                    <td colspan="3" >
                        <button onclick="toRoomPhase()" disabled name="button-seat">
                            Choose Seat
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
