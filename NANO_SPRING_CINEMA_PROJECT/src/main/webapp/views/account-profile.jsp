<%-- 
    Document   : account-profile
    Created on : Sep 5, 2019, 3:25:39 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${account.username}'s Profile - Spring Cinema</title>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/login-register.js"></script>
        <script type="text/javascript" src="resources/js/main.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
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
            
        <h1>My Profile</h1>
        <div>
            <img src="${account.avatar}" style="width: 100px; height: 100px;"/>
            <h4>${account.firstname} ${account.lastname}</h4>
            Points: ${totalPoint}
        </div>
        <div>
            <a href="form-change-password-${account.id}">Change password</a>
        </div>
    </body>
</html>
