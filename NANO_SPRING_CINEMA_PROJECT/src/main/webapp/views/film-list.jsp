<%-- 
    Document   : film-list
    Created on : Sep 5, 2019, 9:56:38 AM
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
            div[name=film]{
                float: left;
                width: 150px;
                height: 200px;
                text-align: center;
                margin: 5px 10px;
            }
            
            div[name=film] img{
                width: 100%;
                height: 150px;
            }
            div[name=title]{
                width: 100%;
                height: 50px;
            }
        </style>
    </head>
    <body>
        <c:forEach var="f" items="${films}" >
            <div name="film" >
                <img src="${f.image}"/>
                <div name="title" >
                    <label>${f.name}</label>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
