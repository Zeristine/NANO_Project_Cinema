<%-- 
    Document   : login
    Created on : Sep 3, 2019, 8:33:05 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Spring Cinema</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <!--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="resources/js/login-register.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col" style="width: 10%"></div>
                <div class="col-6">
                    <div class="myform form ">
                        <div class="logo mb-3">
                            <div class="col-md-12 text-center">
                                <h1>Login</h1>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" name="username" class="form-control" placeholder="Enter Username"
                                   required/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" id="password"  class="form-control" placeholder="Enter Password"
                                   required/>
                        </div>                                                        
                        <div class="col-md-12 text-center mb-3">                                
                            <input type="submit" class="btn btn-block mybtn btn-primary tx-tfm" value="Login" 
                                   onclick="login()"/>
                        </div>          
                    </div>
                </div>
                <div class="col" style="width: 10%"></div>
            </div>
        </div>   
    </body>
</html>
