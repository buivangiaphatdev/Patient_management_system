<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@page import="java.sql.*"%>
<html lang="en">
    <%@include file="includes/header_patient.jsp"%>
    <body>


        <div class="row">

            <%@include file="includes/menu_patient.jsp"%>

            <!---- Content Ares Start  -------->
            <div class="col-md-10 maincontent" >

                <!----------------   Menu Tab   --------------->
                <div class="panel panel-default contentinside">

                    <div class="panel panel-default contentinside">

                        <div class="panel panel-default contentinside">
                            <div class="panel-heading">Edit Patient Information</div>
                            <!----------------   Panel body Start   --------------->
                            <div class="panel-body">
                                <form class="form-horizontal" action="update" method="POST">
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Patient Id:</label>
                                        <div class="col-sm-10">
                                            
                                            <input type="number" class="form-control" name="patientID" placeholder="Patient ID" value="${p.patientID}" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="patientname" value="${p.patientName}" placeholder="Name" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" value="${p.email}" placeholder="Email" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Address</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="add" value="${p.address}" placeholder="Address" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Phone</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="phone" value="${p.phoneNumber}" placeholder="Phone" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Reason Of Visit</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="rov" value="${p.reaOfVisit}" placeholder="Reason Of Visit" >
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Room Number</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="roomNo" value="${p.room_no}" placeholder="Room Number" readonly>
                                        </div>
                                    </div>  

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Bed No.</label>
                                        <div class="col-sm-10" id="beds1">
                                            <input type="text" class="form-control" name="bedNo" value="${p.bed_no}" placeholder="Bed Number" readonly>	
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Reffered To</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="doctorName" value="${p.doctorName}" placeholder="doc name" readonly>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Gender</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="gender" value="${p.gender}" placeholder="Gender" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Admission Date</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="admit_date" value="${p.dateAdd}" placeholder="Admission Date " readonly>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Age</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="age" value="${p.age}" placeholder="Age" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Blood_Group</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="bgroup" value="${p.bGroup}" placeholder="Blood Group" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" name="action" class="btn btn-primary">Save</button>
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