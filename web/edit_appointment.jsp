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
                            <div class="panel-heading">Edit Appointment</div>
                            <!----------------   Panel body Start   --------------->
                            <div class="panel-body">
                                
                                <form class="form-horizontal" action="EditAppointment" method="POST">
                                   
  
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Appointment Id:</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" name="appointmentID" placeholder="Appointment ID" value="${appointment.appointmentID}" readonly="readonly">
                                        </div>
                                    </div>
                                        <div class="form-group">
                                        <label  class="col-sm-2 control-label">Patient Id:</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" name="pID" placeholder="Patient ID" value="${appointment.patientID}" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Patient Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="patientName" value="${appointment.patientName}" placeholder="Name" readonly="readonly">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" value="${appointment.email}" placeholder="Email" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Address</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="add" value="${appointment.address}" placeholder="Address" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Phone</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="phone" value="${appointment.phoneNumber}" placeholder="Phone" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Reason Of Visit</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="rov" value="${appointment.reaOfVisit}" placeholder="Reason Of Visit" >
                                        </div>
                                    </div>

                                    <div class="form-group">    
                                        
                                        <label class="col-sm-2 control-label">DocTor</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" name="doctor">
                                                <option>BVGP</option>
                                                <option>NLT</option>
                                                <option>DVT</option>
                                                <option>BHY</option>
                                                <option>DNBH</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Date</label>
                                        <div class="col-sm-10">
                                            <input type="date" class="form-control" name="date" value="${appointment.app_date}" placeholder="Date" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Time</label>
                                        <div class="col-sm-10">
                                            <input type="time" class="form-control" name="time" value="${appointment.app_time}" placeholder="Time" >
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