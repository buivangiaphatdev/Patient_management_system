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
                            <div class="panel-heading">Change Password</div>
                            <!----------------   Panel body Start   --------------->
                            <div class="panel-body">
                                <form class="form-horizontal" action="ChangePassAdmin" method="POST">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" placeholder="Your Email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">New Password</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="npass" placeholder="Enter New Password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Confirm New Password</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="cpass" placeholder="Confirm New Password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-primary">Update Password</button>
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