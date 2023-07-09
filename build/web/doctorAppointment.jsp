<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id ="apm" class="model.doctor.DoctorDAO" scope="request"></jsp:useBean>
<%@page contentType="text/html" import="model.*,java.util.*" pageEncoding="utf-8" %>


<!DOCTYPE html>
<%@page import="java.sql.*"%>

<html lang="en">
    <head>

        <script src="validation.js"></script>
    </head>
    <%@include file="includes/header_admin.jsp"%>
    <body>

        <div class="row">

            <%@include file="includes/menu_admin.jsp"%>
            <!---- Content Ares Start  -------->
            <div class="col-md-10 maincontent" >
                <!----------------   Menu Tab   --------------->

                <div class="panel panel-default contentinside">
                    <div class="panel-heading">Manage All Appointment</div>
                    <!----------------   Panel body Start   --------------->
                    <div class="panel-body">
                        <ul class="nav nav-tabs doctor">

                        </ul>
                        <div class="formsearch">
                            <form action="SearchAppController" method="POST">
                                Search <input id="inputsearch"type="text" name="search" />
                                <input id="searchbutton" type="submit"  value="Search"/>    
                            </form>
                        </div>

                        <!----------------   Display Patients Data List Start  --------------->
                        <div id="doctorlist" class="switchgroup">
                            <table class="table table-bordered table-hover">
                                <tr class="active">
                                    <td>#</td>
                                    <td>Appointment ID</td>
                                    <td>Doctor ID</td>
                                    <td>Doctor Name</td>
                                    <td>Patient ID</td>
                                    <td>Patient Name</td>
                                    <td>Phone Number</td>
                                    <td>Reason Of Visit</td>
                                    <td>Date</td>
                                    <td>Time</td>
                                    <td>Email</td>
                                    <td>Create Time</td>
                                    <td>Option</td>

                                </tr>
                                <tr> 
                                    <%
                                        int count = 1;%>
                                    <c:forEach items="${apps}" var="apps">
                                        <td><%= count++%></td>
                                        <td>${apps.appointmentID}</td>
                                        <td>${apps.doctorID}</td>
                                        <td>${apps.doctorName}</td>
                                        <td>${apps.patientID}</td>
                                        <td>${apps.patientName}</td>
                                        <td>${apps.phoneNumber}</td>
                                        <td>${apps.reaOfVisit}</td>
                                        <td>${apps.app_date}</td>
                                        <td>${apps.app_time}</td>
                                        <td>${apps.email}</td>
                                        <td>${apps.create_time}</td>
                                        <td>
                                            <a href="DoctorDeleteApp?appid=${apps.appointmentID}">Delete<a>
                                                    </td>

                                                    </tr>
                                                </c:forEach>
                                                </table>
                                                <c:forEach begin="1" end="${apm.totalAppointment}" var="i">
                                                    <a href="PagingAppDoctor?index=${i}">${i}</a>
                                                </c:forEach>
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