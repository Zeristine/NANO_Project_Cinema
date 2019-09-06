<%-- 
    Document   : order-book-phase-2
    Created on : Sep 6, 2019, 10:42:35 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book a Room</h1>
        <table border="0">            
            <tbody>
                <tr>
                    <th colspan="2" >Film</th>
                    <th colspan="2" >Showing Date</th>
                    <th colspan="2" >Showing Time</th>
                </tr>
                <tr>
<!--                    <td colspan="2" >
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
                    </td>-->
                </tr>
                <tr>
                    <td colspan="3" >
                        <button onclick="backToPrevious()" >
                            Back
                        </button>
                    </td>
                    <td colspan="3" >
                        <button onclick="clearAllOrder()" >
                            Cancel
                        </button>
                    </td>
                    <td colspan="3" >
                        <button onclick="toConfirmPhase()" disabled name="button-seat">
                            Confirm
                        </button>
                    </td>
                </tr>
            </tbody>
    </body>
</html>
