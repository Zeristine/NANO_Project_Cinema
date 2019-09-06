<%-- 
    Document   : udpate-profile
    Created on : 06-Sep-2019, 15:04:24
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
                                <h1>Update Profile</h1>
                            </div>
                        </div>
                        <form action="update-profile" method="POST">
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" name="username" class="form-control" 
                                       disabled="disabled" value="${account.username}" 
                                       required/>
                                <!--<input type="hidden" name="username" value="${account.username}" />-->
                                <input type="hidden" name="id" value="${account.id}" />
                            </div>
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text"  name="firstname" class="form-control" id="firstname" 
                                       placeholder="Enter Firstname" value="${account.firstname}"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text"  name="lastname" class="form-control" id="lastname" 
                                       placeholder="Enter Lastname" value="${account.lastname}"
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Birthdate</label>
                                <input type="date" name="birthdate" class="form-control" id="birthdate" 
                                       value="${account.birthdate}" 
                                       required/>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" name="phone" class="form-control" id="birthdate" 
                                       placeholder="Enter Phone" value="${account.phone}" 
                                       required/>
                            </div>
                            <div class="col-md-12 text-center mb-3">
                                <!--<button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Register</button>-->
                                <input type="submit" class="btn btn-block mybtn btn-primary tx-tfm" value="Update profile" />
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
