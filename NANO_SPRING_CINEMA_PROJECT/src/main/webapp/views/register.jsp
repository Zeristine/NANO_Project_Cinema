<%-- 
    Document   : register
    Created on : 01-Sep-2019, 12:37:40
    Author     : HaAnh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Cinema</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <!--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="resources/css/main.css"/>
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>        
        <script type="text/javascript" src="resources/js/login-register.js"></script>
        <script>
            function validateRegister() {
                console.log("validateRegister()");
                var username = $("input[name=username]").val().trim();
                var password = $("input[name=password").val().trim();
                var retype = $("input[name=retype").val().trim();
                var firstname = $("input[name=firstname").val().trim();
                var lastname = $("input[name=lastname").val().trim();
                var birthdate = $("input[name=birthdate").val().trim();
                var phone = $("input[name=phone").val().trim();
                var msg = "";
                if (username.length == 0 || password.length == 0 || retype.length == 0
                        || firstname.length == 0 || lastname.length == 0
                        || birthdate.length == 0 || phone.length == 0) {
                    msg = "Please input all fields";
                } else {
                    if (password.length < 5) {
                        msg += "Password length >= 5";
                    } else if (password !== retype) {
                        msg += "Password and confirm must match\n";
                    }
                }
                msg = msg.trim();
                if (msg.length > 0) {
                    alert(msg);
                    return false;
                } else {
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <div class="header" >
            <div class="left" >
                <button onclick="backToHome()" >NANO Spring Cinema</button>
            </div>
            <div class="right" name="not-logged">
                <a href="#" >
                    <button class="active" >Register</button>
                </a>
                <a href="form-login">
                    <button>Log in</button>
                </a>
                <button onclick="">Ticket Price</button>
            </div>            
        </div>        
        <div class="container">
            <div class="row">
                <div class="col" style="width: 10%"></div>
                <div class="col-6">
                    <div class="myform form ">
                        <div class="logo mb-3">
                            <div class="col-md-12 text-center">
                                <h1>Register new Account</h1>
                            </div>
                        </div>
                        <form action="register" name="myForm" onsubmit="return validateRegister()" method="POST">
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
                            <div class="form-group">
                                <label>Confirm</label>
                                <input type="password" name="retype" id="password" class="form-control" placeholder="Enter Password"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text"  name="firstname" class="form-control" id="firstname" placeholder="Enter Firstname"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text"  name="lastname" class="form-control" id="lastname" placeholder="Enter Lastname"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Birthdate</label>
                                <input type="date" name="birthdate" class="form-control" id="birthdate" placeholder="Enter Birthdate"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="number" name="phone" class="form-control" id="birthdate" placeholder="Enter Phone"
                                       required/>
                            </div>
                            <div class="col-md-12 text-center mb-3">
                                <!--<button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Register</button>-->
                                <input type="submit" class="btn btn-block mybtn btn-primary tx-tfm" value="Register" />
                            </div>
                            <c:if test="${not empty msg}">
                                <div style="color: red;" class="text-center">
                                    ${msg}
                                </div>
                            </c:if>
                            <c:if test="${empty success}">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <p class="text-center">
                                            Already have an account? <a href="form-login">Login</a>
                                        </p>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${success eq true}">
                                <div class="text-center">
                                    Register success, click here to <a href="form-login">Login</a>
                                </div>
                            </c:if>
                        </form>
                    </div>
                </div>
                <div class="col" style="width: 10%"></div>
            </div>
        </div>   
    </body>
</html>
