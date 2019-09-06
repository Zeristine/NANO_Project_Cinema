<%-- 
    Document   : order-book-phase-2
    Created on : Sep 6, 2019, 10:42:35 AM
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
            table button{
                width: 100%;
            }
            table select{
                width: 100%;
            }
            .booked{
                background-color: red;
                color: white;
            }
            .selected{
                background-color: green;
                color: white;
            }
        </style>
    </head>
    <body>

        <table border="0">            
            <tbody>
                <tr>
                    <th colspan="3" >
                        <h2>Choose a Seat in Room ${showTime.room.id} on ${showTime.showDate} to watch ${showTime.film.name}</h2>
                    </th>
                </tr>
                <tr>
                    <th>Choose Amount</th>
                    <td>
                        <select name="amount" onchange="removeSeatDisable(this)" >
                            <option>Select number of seats</option>
                            <c:forEach begin="0" end="${24 - showTime.totalBookedTicket}" varStatus="counter" >
                                <option value="${counter.count}" >${counter.count}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <th>Ticket(s)</th>
                </tr>                
            </tbody>
        </table>
        <table border="0" name="seats" >
            <thead>
                <tr>
                    <th colspan="5" style="background-color: black; color: white; height: 150px;" >Screen</th>                        
                </tr>
                <tr>
                    <th colspan="5" style="height: 25px;" ></th>                        
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach begin="0" end="4" varStatus="counter" >
                        <td>
                            <button value="A-${counter.count}" 
                                    <c:forEach var="pos" items="${showTime.bookedSeats}" >
                                        <c:forTokens var="val" items="${pos}" delims="-" varStatus="mcounter" >
                                            <c:if test="${mcounter.count == 1}" >
                                                <c:set var="row" value="${val}" />
                                            </c:if>
                                            <c:if test="${mcounter.count == 2}" >
                                                <c:if test="${val == counter.count && row eq 'A'}" >
                                                    disabled class="booked"
                                                </c:if>
                                            </c:if>
                                        </c:forTokens>                                        
                                    </c:forEach> onclick="select(this)"
                                    >A${counter.count}</button>
                        </td>
                    </c:forEach>                                                                
                </tr>                    
                <tr>
                    <c:forEach begin="0" end="4" varStatus="counter" >
                        <td>
                            <button value="B-${counter.count}" 
                                    <c:forEach var="pos" items="${showTime.bookedSeats}" >
                                        <c:forTokens var="num" items="${pos}" delims="-" varStatus="mcounter" >
                                            <c:if test="${mcounter.count == 1}" >
                                                <c:set var="row" value="${val}" />
                                            </c:if>
                                            <c:if test="${mcounter.count == 2}" >
                                                <c:if test="${val == counter.count && row eq 'B'}" >
                                                    disabled class="booked"
                                                </c:if>
                                            </c:if>
                                        </c:forTokens>                                        
                                    </c:forEach> onclick="select(this)"
                                    >B${counter.count}</button>
                        </td>
                    </c:forEach>                                                                
                </tr>                    
                <tr>
                    <c:forEach begin="0" end="4" varStatus="counter" >
                        <td>
                            <button value="C-${counter.count}" 
                                    <c:forEach var="pos" items="${showTime.bookedSeats}" >
                                        <c:forTokens var="num" items="${pos}" delims="-" varStatus="mcounter" >
                                            <c:if test="${mcounter.count == 1}" >
                                                <c:set var="row" value="${val}" />
                                            </c:if>
                                            <c:if test="${mcounter.count == 2}" >
                                                <c:if test="${val == counter.count && row eq 'C'}" >
                                                    disabled class="booked"
                                                </c:if>
                                            </c:if>
                                        </c:forTokens>                                        
                                    </c:forEach> onclick="select(this)"
                                    >C${counter.count}</button>
                        </td>
                    </c:forEach>                                                                
                </tr>                    
                <tr>
                    <c:forEach begin="0" end="4" varStatus="counter" >
                        <td>
                            <button value="D-${counter.count}" 
                                    <c:forEach var="pos" items="${showTime.bookedSeats}" >
                                        <c:forTokens var="num" items="${pos}" delims="-" varStatus="mcounter" >
                                            <c:if test="${mcounter.count == 1}" >
                                                <c:set var="row" value="${val}" />
                                            </c:if>
                                            <c:if test="${mcounter.count == 2}" >
                                                <c:if test="${val == counter.count && row eq 'D'}" >
                                                    disabled class="booked"
                                                </c:if>
                                            </c:if>
                                        </c:forTokens>                                        
                                    </c:forEach> onclick="select(this)"
                                    >D${counter.count}</button>
                        </td>
                    </c:forEach>                                                                
                </tr>                    
                <tr>
                    <c:forEach begin="0" end="4" varStatus="counter" >
                        <td>
                            <button value="E-${counter.count}" 
                                    <c:forEach var="pos" items="${showTime.bookedSeats}" >
                                        <c:forTokens var="num" items="${pos}" delims="-" varStatus="mcounter" >
                                            <c:if test="${mcounter.count == 1}" >
                                                <c:set var="row" value="${val}" />
                                            </c:if>
                                            <c:if test="${mcounter.count == 2}" >
                                                <c:if test="${val == counter.count && row eq 'E'}" >
                                                    disabled class="booked"
                                                </c:if>
                                            </c:if>
                                        </c:forTokens>                                        
                                    </c:forEach> onclick="select(this)"
                                    >E${counter.count}</button>
                        </td>
                    </c:forEach>                                                                
                </tr>                                    
            </tbody>
        </table>
        <table>
            <tbody> 
                <tr>
                    <td><button class="booked" disabled >Booked</button></td>
                    <td><button class="selected" disabled>Selected</button></td>
                    <td><button class="" disabled>Available</button></td>
                </tr>
                <tr>
                    <td>
                        <button onclick="backToPrevious()" >
                            Back
                        </button>
                    </td>
                    <td>
                        <button onclick="clearAllOrder()" >
                            Cancel
                        </button>
                    </td>
                    <td>
                        <button onclick="toConfirmPhase()" disabled name="button-seat">
                            Confirm
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
