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
        <title>Spring Cinema</title>
        <style>
            div[name=film]{
                float: left;
                width: 200px;
                height: 450px;
                margin: 5px 10px;
            }

            div[name=film] img{
                float: left;
                width: 100%;
                height: 60%;
            }
            div[name=title]{
                float: left;
                width: 100%;
                height: 39%;                
            }            
            ul{
                list-style: square;
            }
            div[name=search-form]{
                width: 100%;
            }
            div[name=search-form] input[type=text]{
                width: 80%;
            }
            div[name=search-form] input[type=submit]{
                width: 19%;
            }
        </style>
    </head>
    <body>
        <div name="search-form">
            <input type="text" name="name" value="${search}" placeholder="Search film" />
            <input type="submit" value="Search" onclick="search()"/>
        </div>
        <hr/>
        <c:if test="${not empty films}">
            <c:forEach var="f" items="${films}">
                <div name="film">
                    <img src="${f.image}"/>
                    <div name="title" >
                        <h3>${f.name}</h3>
                        <ul>
                            <li>Category:
                                <c:forEach var="cg" items="${f.categories}" >
                                    <a href="category-${cg.name}" >
                                        <button>${cg.name}</button>
                                    </a>
                                </c:forEach>
                            </li>
                            <li>Duration: ${f.duration}</li>
                            <li>Start Date: ${f.fromDate}</li>
                        </ul>
                        <c:if test="${current eq true}">
                            <a href="book-ticket/${f.id}">
                                <button>Book Ticket</button>
                            </a>
                        </c:if>                                                    
                        <a href="film-detail-${f.id}" >
                            <button>Show Detail</button>
                        </a>                        
                    </div>                    
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${not empty toBeOutFilms}">
            <c:forEach var="f" items="${toBeOutFilms}">
                <div name="film">
                    <img src="${f.image}"/>
                    <div name="title" >
                        <h3>${f.name}</h3>
                    </div>
                    <ul>
                        <li>Category: </li>
                        <li>Duration: ${f.duration}</li>
                        <li>Start Date: ${f.fromDate}</li>
                    </ul>
                    
                    <form action="film-detail-${f.id}" method="GET">
                        <input type="submit" value="View Detail" />
                    </form>
                </div>
            </c:forEach>
        </c:if>
    </body>
</html>
