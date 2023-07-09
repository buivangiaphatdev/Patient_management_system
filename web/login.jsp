

<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Patient Management System</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.js"></script>

    </head>
    <body>

        <div class="container-fluid">
            <!--- Header --------------------------->
            <div class="row navbar-fixed-top">
                <nav class="navbar navbar-default header">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand logo" href="#">
                                <img alt="Brand" src="images/logo.png">
                            </a>
                            <div class="navbar-text title"><p>Patient Management System<p></div>
                        </div>
                    </div>
                </nav>
            </div>
            <!--- Header Ends Here --------------------------->

            <div class="row ">
                <div class="col-md-12">
                    <div class="panel panel-default login">
                        <div class="panel-heading logintitle">Login</div>

                        <div class="panel-body">
                            <form class="form-horizontal center-block" role="form" action="login" method="post">

                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
                                    <select class="form-control" name="userrole">
                                        <option selected="selected">Select User</option>
                                        <option value="admin">Admin</option>
                                        <option value="patient">Patient</option>
                                         <option value="doctor">Doctor</option>

                                    </select>
                                </div>
                                <br/>
                                <div>

                                </div>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span>
                                    <input type="email" class="form-control" name="email" placeholder="example@gmail.com" required aria-describedby="sizing-addon1">
                                </div>

                                <br/>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
                                    <input type="password" name="password" class="form-control" placeholder="Password" required aria-describedby="sizing-addon1">
                                </div>
                                <br/>
                                <div class="col-sm-7 col-sm-offset-2">
                                    <input type="submit" name="action" value="Login" class="btn btn-primary btn-block btn-lg"/>
                                </div>
                            </form>
                        </div>
                        <a href="register.jsp" style="text-align:Center;font-weight:bold;font-size:120%;padding: 0 2%">Register As Patient</a>						
                    </div>
                </div>				
            </div>

            <div class="row footer navbar-fixed-bottom">
              
            </div>


        </div>

        <script src="js/bootstrap.min.js"></script>

    </body>
</html>