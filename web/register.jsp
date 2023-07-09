

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
                <a href="index.jsp" style="text-align:Center;font-weight:bold;font-size:120%;padding: 0 2%;color:red">LOGIN</a>						
            </div>
            <!--- Header Ends Here --------------------------->

            <div class="row ">
                <div class="col-md-12">
                    <div class="panel panel-default login">
                        <div class="panel-heading logintitle">Register As Patient</div>

                        <div class="panel-body">
                            <form class="form-horizontal center-block" role="form" action="patientConfirm.jsp" method="POST">

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Patient Id:</label>
                                    <div class="col-sm-10">
                                        <input type="number" class="form-control" name="patientid" placeholder="unique_id auto generated" readonly>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Name</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="patientName" placeholder="Name" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" name="email" placeholder="Email" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Password</label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" name="password" placeholder="Password" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Address</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="address" placeholder="Address" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Phone</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="phoneNumber" placeholder="Phone No." required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Reason Of Visit</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="reaOfVisit" placeholder="Reason Of Visit" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Room No</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" value="" name="roomNo" placeholder="Left for Admin" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Bed No</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="bedNo" placeholder="Left for Admin" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">To Be reffered To</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="doctorName" placeholder="Left for Admin" readonly>
                                    </div>
                                </div>
                                <div class="form-group">    
                                    <label class="col-sm-2 control-label">Gender</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" name="gender">
                                            <option>Male</option>
                                            <option>Female</option>
                                            <option>Other</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Admission Date</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="dateAdd" placeholder="Left For Admin" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Age</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="age" placeholder="Age" required>
                                    </div>
                                </div>
                                <div class="form-group">    
                                    <label class="col-sm-2 control-label">Blood Group</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" name="bGroup">
                                            <option>A<sup>+</sup></option>
                                            <option>A<sup>-</sup></option>
                                            <option>B<sup>+</sup></option>
                                            <option>B<sup>-</sup></option>
                                            <option>AB<sup>+</sup></option>
                                            <option>AB<sup>-</sup></option>
                                            <option>O<sup>+</sup></option>
                                            <option>O<sup>-</sup></option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-7 col-sm-offset-2" style="margin:0 0 0 40%">
                                        <input type="submit" name="action" value="Register As Patient Now" class="btn btn-primary">
                                    </div>
                                </div>
                                <br><Br><Br>

                            </form>
                        </div>					
                    </div>
                </div>				
            </div>

            <div class="row footer navbar-fixed-bottom">
                <div class="col-md-12">
                    <div>Designed and Developed By BVGP </div>
                    <p>Patient Management System</p>
                </div>
            </div>	


            <!--- Footer ---------------------------

                
                <div class="row marginreset">
                        <div class="col-md-12 footer" >
                                <p class="developer">Designed and Developed By # #</p>
                                <p>Copyrights © Hospital Management System 2017-18. All rights reserved. </p>
                                
                        </div>
                        
                </div>
                
            <!--- Footer Ends Here --------------------------->
        </div>

        <script src="js/bootstrap.min.js"></script>

    </body>
</html>