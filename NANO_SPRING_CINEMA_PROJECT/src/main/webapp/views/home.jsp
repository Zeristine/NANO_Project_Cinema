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
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <div class="header" >
            <div class="left" >
                <button onclick="reload()" >NANO Spring Cinema</button>
            </div>
            <div class="right hide" name="not-logged">
                <a href="form-register" >
                    <button>Register</button>
                </a>
                <a href="form-login">
                    <button>Log in</button>
                </a>
                <button onclick="getTicketForm(this)">Book Ticket</button>                
                <button onclick=getTicketPriceList(this)">Ticket Price</button>                
            </div>
            <div class="right hide" name="logged">
                <button onclick="logout()" >Log out</button>           
                <button name="logged" onclick="showProfile(this)"></button>
                <button onclick="getTicketForm(this)">Book Ticket</button>                
                <button onclick="getTicketPriceList(this)">Ticket Price</button>                
            </div>
        </div>        
        <div id="main-content" ></div>        
    </body>
</html>
