<%-- 
    Document   : order-book-main
    Created on : Sep 5, 2019, 3:46:19 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Ticket - Spring Cinema</title>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/login-register.js"></script>
        <script type="text/javascript" src="resources/js/main.js"></script>
        <link rel="stylesheet" href="resources/css/main.css"/>
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
                <a href="#">
                    <button class="active">Book Ticket</button>                    
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
                <a href="#">
                    <button class="active">Book Ticket</button>                    
                </a>
                <a href="ticket-price">
                    <button class="">Ticket Price</button>                
                </a>                
            </div>
        </div>        
        <div id="main-content" >
            
        </div>
    </body>
</html>
