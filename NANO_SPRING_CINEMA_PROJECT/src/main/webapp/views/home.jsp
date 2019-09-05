<%-- 
    Document   : home
    Created on : Aug 25, 2019, 6:23:27 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Cinema</title>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/login-register.js"></script>
        <script type="text/javascript" src="resources/js/home.js"></script>
        <style>
            #film-content{
                float: left;
                width: 90%;
                margin-left: 10%;
                margin-right: 10%;
            }
        </style>
    </head>
    <body>
        <a href="form-register" >Register</a>
        <a href="form-login">Login</a>
        <div id="film-content" ></div>        
    </body>
</html>
