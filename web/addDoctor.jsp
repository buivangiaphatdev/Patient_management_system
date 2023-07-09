<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html lang="en">
    <%@include file="includes/header_admin.jsp"%>
    <body>


        <div class="row">

            <%@include file="includes/menu_admin.jsp"%>

            <!---- Content Ares Start  -------->
            <div class="col-md-10 maincontent" >

                <!----------------   Menu Tab   --------------->
                <div class="panel panel-default contentinside">

                    <div class="panel panel-default contentinside">

                        <div class="panel panel-default contentinside">
                            <div class="panel-heading">Add Doctor</div>
                            <!----------------   Panel body Start   --------------->
                            <div class="panel-body">
                                <form class="form-horizontal" action="CreateDoctor" method="POST">
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Doctor Id:</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" name="docID" placeholder="id auto generated" readonly="readonly">
                                        </div>
                                    </div>
                                    <!--                                    
                                                                        <div class="form-group">
                                                                            <label  class="col-sm-2 control-label">Doctor Name</label>
                                                                            <div class="col-sm-10">
                                                                                <input type="text" class="form-control" name="docName"  placeholder="Name" >
                                                                            </div>
                                                                        </div>-->
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Doctor Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="docName"  placeholder="Doctor Name" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" value="" placeholder="Email" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Password</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="pass" value="" placeholder="Password" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Address</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="add" value="" placeholder="Address" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Phone</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="phone" value="" placeholder="Phone" >
                                        </div>
                                    </div>
                                    <div class="form-group">    
                                        <label class="col-sm-2 control-label">Department</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" name="dept">
                                                <option>Neurology</option>
                                                <option>Cardiology</option>
                                                <option>Gastroenterology</option>
                                                <option>Gynaecology</option>
                                                <option>Haematology</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" name="action" class="btn btn-primary">Create</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!----------------   Panel body Ends   --------------->
                        </div>
                    </div>

                </div>
            </div>
            <script src="js/bootstrap.min.js"></script>
    </body>
</html>