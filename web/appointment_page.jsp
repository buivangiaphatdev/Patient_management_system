<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.*"%>
<%@page import="model.doctor.DoctorDAO"%>
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
                            <div class="panel-heading">Add Appointment</div>
                            <!----------------   Panel body Start   --------------->
                            <div class="panel-body">
                                <form class="form-horizontal" action="CreateAppointment" method="POST">
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Appointment Id:</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" name="appID" placeholder="id auto generated" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Patient Id:</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" name="patientID" placeholder="Patient ID" value="${p.patientID}" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="patientName" value="${p.patientName}" placeholder="Name" readonly="readonly">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" value="" placeholder="Email" >
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
                                        <label  class="col-sm-2 control-label">Reason Of Visit</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="rov" value="" placeholder="Reason Of Visit" >
                                        </div>
                                    </div>

                                    <div class="form-group">    
                                        <label class="col-sm-2 control-label">DocTor</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" name="doctor">
                                                <c:forEach items="${DoctorDAO.listAllDoctor()}" var="d">
                                                    <option value="${d.docName}">${d.docName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Date</label>
                                        <div class="col-sm-10">
                                            <input type="date" class="form-control" name="date" value="" placeholder="Date" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Time</label>
                                        <div class="col-sm-10">
                                            <input type="time" class="form-control" name="time" value="" placeholder="Time" >
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