<%-- 
    Document   : film-detail
    Created on : 05-Sep-2019, 13:48:32
    Author     : HaAnh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Cinema</title>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/login-register.js"></script>
        <script type="text/javascript" src="resources/js/main.js"></script>
        <link rel="stylesheet" href="resources/css/main.css"/>
        <style>
            table{
                width: 100%;
                text-align: left;
            }
            .img-content{
                text-align: center;
            }
            .description{
                text-align: left;   
            }
            iframe{
                width: 100%;                
                height: 500px;
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
        <table border="0">
            <tr>
                <td rowspan="8" class="img-content">
                    <img src="${film.image}"/>
                </td>
            </tr>
            <tr>
                <th colspan="1">
                    <h2>${film.name}</h2>
                </th>
                <td>
                    <c:if test="${current eq true}">
                        <a href="book-ticket/${f.id}">
                            <button>Book Ticket</button>
                        </a>    
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Time:</th>
                <td>${film.fromDate} - ${film.toDate}</td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <c:forEach var="cg" items="${film.categories}" >
                        <a href="category-${cg.name}" >
                            <button>${cg.name}</button>
                        </a>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <th>Actors:</th>
                <td></td>
            </tr>
            <tr>
                <th>Director</th>
                <td></td>
            </tr>
            <tr>
                <th>Duration</th>
                <td>${film.duration}</td>
            </tr>
            <tr>
                <th>Company</th>
                <td>${film.company.name}</td>
            </tr>
            <tr>
                <th colspan="4">Description</th>                

            </tr>
            <tr>
                <td colspan="4" class="description" >
                    <p>${film.description}</p>
                </td>                
            </tr>
            <tr>
                <th colspan="4">Trailer</th>                
            </tr>
            <tr>
                <td colspan="4"><iframe width="420" height="280" src="${film.video}"></iframe> </td>
            </tr>            
        </table>                
    </body>
</html>
