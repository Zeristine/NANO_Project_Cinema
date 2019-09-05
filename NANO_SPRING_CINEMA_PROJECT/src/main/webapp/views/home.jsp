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
/*            #film-content{
                float: left;
                width: 90%;
                margin-left: 10%;
                margin-right: 10%;
            }*/
            .header{
                float: left;
                width: 100%;
                height: 50px;
                padding-top: 10px;
                padding-bottom: 10px;
                margin-bottom: 10px;
                background-color: black;
            }
            .header button{
                float: right;
                width: 200px;
                height: 100%;
                margin-left: 5px;
                margin-right: 5px;
                border-radius: 10px 10px;
                font-size: 20px;
            }
            .logged{
                width: 100%;
                height: 100%;
                display: none;
            }
            label[name=welcome]{
                color: white;
                height: 100%;
                float: right;                
                margin-right: 20px;
            }
            .active{
                font-weight: bolder;
            }
        </style>
    </head>
    <body>
        <div class="header" >
            <div class="logged appear" name="not-logged">
                <a href="form-register" >
                    <button>Register</button>
                </a>
                <a href="form-login">
                    <button>Log in</button>
                </a>
                <button onclick="">Ticket Price</button>
            </div>
            <div class="logged" name="logged">
                <button onclick="logout()" >Log out</button>           
                <button onclick="getTicketForm(this)">Book Ticket</button>                
                <button onclick="getTicketPriceList(this)">Ticket Price</button>
                <button name="logged" onclick="showProfile()"></button>
            </div>
        </div>        
        <div id="main-content" ></div>        
    </body>
</html>
