<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" import="model.*,java.util.*" pageEncoding="utf-8" %>


<!DOCTYPE html>
<%@page import="java.sql.*"%>

<html lang="en">
    <head>

        <script src="validation.js"></script>
    </head>
    <%@include file="includes/header_patient.jsp"%>
    <body>

        <div class="row">

            <%@include file="includes/menu_patient.jsp"%>
            <!---- Content Ares Start  -------->
            <div class="col-md-10 maincontent" >
                <!----------------   Menu Tab   --------------->

                <div class="panel panel-default contentinside">
                    <div class="panel-heading">Manage Patient</div>
                    <!----------------   Panel body Start   --------------->
                    <div class="panel-body">
                        <ul class="nav nav-tabs doctor">
                            <li role="presentation"><a href="patient_page.jsp">Patient List</a></li>
                            <li role="presentation"><a href="appointment_page.jsp">Create Appointment</a></li>
                        </ul>


                        <!----------------   Display Patients Data List Start  --------------->
                        <div id="doctorlist" class="switchgroup">
                            <table class="table table-bordered table-hover">
                                <tr class="active">
                                    <td>#</td>
                                    <td>Patient ID</td>
                                    <td>Patient Name</td>
                                    <td>Email</td>
                                    <td>Address</td>
                                    <td>Phone</td>
                                    <td>Reason Of Visit</td>
                                    <td>Doctor</td>
                                    <td>Date</td>
                                    <td>Time</td>
                                    <td>Create Time</td>
                                    <td>Option</td>

                                </tr>

                                <c:forEach items="${apps}" var="c">
                                    <tr> 
                                        <td>${c.appointmentID}</td>
                                        <td>${c.patientID}</td>
                                        <td>${c.patientName}</td>
                                        <td>${c.email}</td>
                                        <td>${c.address}</td>
                                        <td>${c.phoneNumber}</td>
                                        <td>${c.reaOfVisit}</td>
                                        <td>${c.doctorName}</td>  
                                        <td>${c.app_date}</td>
                                        <td>${c.app_time}</td>
                                        <td>${c.create_time}</td>
                                        <td> <a href="EditAppointment?uid=${c.appointmentID}">Edit<a>
                                             <a href="delete?id=${c.appointmentID}&aid=${c.patientID}">Delete<a>
                                                            </td>

                                    </tr>
                                </c:forEach>


                            </table>
                        </div>

                    </div>
                    <!----------------   Panel body Ends   --------------->
                </div>
            </div>
        </div>
    </div>




    <script src="js/bootstrap.min.js"></script>
</body>
</html>