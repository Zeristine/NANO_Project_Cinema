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
        <title>Register - Spring Cinema</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <!--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">-->
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
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
                    msg = "Please input all fields \n"
                            + "Username :" + username.length + "\n"
                            + "Password :" + password.length + "\n"
                            + "Re :" + retype.length + "\n"
                            + "First :" + firstname.length + "\n"
                            + "Last :" + lastname.length + "\n"
                            + "Birth :" + birthdate.length + "\n"
                            + "Phone :" + phone.length;
                    +"\n"
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
                                <input type="text" name="username" class="form-control" placeholder="Enter Username">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" name="password" id="password"  class="form-control" placeholder="Enter Password">
                            </div>
                            <div class="form-group">
                                <label>Confirm</label>
                                <input type="password" name="retype" id="password" class="form-control" placeholder="Enter Password">
                            </div>
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text"  name="firstname" class="form-control" id="firstname" placeholder="Enter Firstname">
                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text"  name="lastname" class="form-control" id="lastname" placeholder="Enter Lastname">
                            </div>
                            <div class="form-group">
                                <label>Birthdate</label>
                                <input type="date" name="birthdate" class="form-control" id="birthdate" placeholder="Enter Birthdate">
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" name="phone" class="form-control" id="birthdate" placeholder="Enter Phone">
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
                                            Already have an account? <a href="#">Login</a>
                                        </p>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${success eq true}">
                                <div class="text-center">
                                    Register success, click here to <a href="#">Login</a>
                                </div>
                            </c:if>
                        </form>
                    </div>
                </div>
                <div class="col" style="width: 10%"></div>
            </div>
        </div>   
        <!--        <form action="register" method="POST" name="myForm" onsubmit="return validateRegister()">
                <div class="form-register-row">
                    <label>Username</label>
                    <input type="text" name="username" value="" />
                </div>
                <div class="form-register-row">
                    <label>Password</label>
                    <input type="password" name="password" value="" />
                </div>
                <div class="form-register-row">
                    <label>Confirm Password</label>
                    <input type="password" name="retype" value="" />
                </div>
                <div class="form-register-row">
                    <label>Firstname</label>
                    <input type="text" name="firstname" value="" />
                </div>
                <div class="form-register-row">
                    <label>Lastname</label>
                    <input type="text" name="lastname" value="" />
                </div>
                <div class="form-register-row">
                    <label>Birthdate</label>
                    <input type="text" name="birthdate" value="" />
                </div>
                <div class="form-register-row">
                    <label>Phone</label>
                    <input type="text" name="phone" value="" />
                </div>
                <div>
                    <input type="submit" class="btn btn-info" value="Register" />
                </div>
                </form>-->
    </body>
</html>
