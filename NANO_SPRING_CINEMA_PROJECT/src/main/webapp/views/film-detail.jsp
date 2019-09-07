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
            table {
                /*width: 100%;*/
                text-align: left;
            }
            .img-content{
                text-align: center;
                height: 300px;                
            }
            .description{
                text-align: left;   
            }
            iframe{
                width: 480px;
            }
            .film-title {
                font-size: 30px;
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
                    <img src="${film.image}" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td colspan="1" style="padding-left: 50px; font-size: 20px; font-weight: bold">
                    ${film.name}
                </td>
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
                    ${categories}
                    <%--<c:forEach var="cg" items="${film.categories}" >--%>
                        <!--<a href="category-${cg.name}" >-->
                            <!--<button>${cg.name}</button>-->
                        <!--</a>-->
                    <%--</c:forEach>--%>
                </td>
            </tr>
            <tr>
                <th>Actors:</th>
                <td>${actors}</td>
            </tr>
            <tr>
                <th>Director</th>
                <td>${director}</td>
            </tr>
            <tr>
                <th>Duration</th>
                <td>${film.duration} minutes</td>
            </tr>
            <tr>
                <th>Company</th>
                <td>${film.company.name}</td>
            </tr>           
        </table> 
        <h3>Description</h3>
        <p>${film.description}</p>            
        <h3>Trailer</h3>            
        <iframe width="420" height="280" src="${film.video}"></iframe> 

    </body>
</html>
