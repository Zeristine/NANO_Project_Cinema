<%-- 
    Document   : change-password
    Created on : 06-Sep-2019, 12:52:12
    Author     : HaAnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Cinema</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col" style="width: 10%"></div>
                <div class="col-6">
                    <div class="myform form ">
                        <div class="logo mb-3">
                            <div class="col-md-12 text-center">
                                <h1>Change password</h1>
                            </div>
                        </div>
                        <form action="change-password" method="POST">
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" name="username" class="form-control" 
                                       disabled="disabled" value="${account.username}" 
                                       required/>
                                <input type="hidden" name="username" value="${account.username}" />
                                <input type="hidden" name="id" value="${account.id}" />
                            </div>
                            <div class="form-group">
                                <label>Old Password</label>
                                <input type="password" name="oldPassword" id="password"  class="form-control" placeholder="Old Password"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>New Password</label>
                                <input type="password" name="newPassword" id="password"  class="form-control" placeholder="Enter Password"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Confirm</label>
                                <input type="password" name="retype" id="password" class="form-control" placeholder="Confirm Password"
                                       required/>
                            </div>
                            <div class="col-md-12 text-center mb-3">
                                <!--<button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Register</button>-->
                                <input type="submit" class="btn btn-block mybtn btn-primary tx-tfm" value="Change password" />
                            </div>
                            <c:if test="${not empty msg}">
                                <div style="color: red;" class="text-center">
                                    ${msg}
                                </div>
                            </c:if>
                            
<!--                            <c:if test="${success eq true}">
                                <div class="text-center">
                                    Update password success
                                </div>
                            </c:if>-->
                        </form>
                    </div>
                </div>
                <div class="col" style="width: 10%"></div>
            </div>
        </div> 
    </body>
</html>
