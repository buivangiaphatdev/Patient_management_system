<%@page import="java.util.ArrayList"%>
<%@page import="model.Patient"%>
<!DOCTYPE html>
<jsp:useBean id ="a" class="model.PatientDAO" scope="request"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" import="model.*,java.util.*" pageEncoding="utf-8" %>
<%--<jsp:useBean id="patient" class="java.util.ArrayList" scope="session"/>--%>
<html lang="en">
    <%@include file="includes/header_admin.jsp"%>
    <body>


        <div class="row">

            <%@include file="includes/menu_admin.jsp"%>

            <!-------   Content Area start  --------->
            <div class="col-md-10 maincontent" >

                <!-----------  Content Menu Tab Start   ------------>
                <div class="panel panel-default contentinside">
                    <div class="panel-heading">Manage All Patients</div>

                    <!----------------   Panel Body Start   --------------->
                    <div class="panel-body">
                        <ul class="nav nav-tabs doctor">
                            <li role="presentation"><a href="admin.jsp">Patient List</a></li>

                        </ul>
                        <div class="formsearch">
                            <form action="SearchController" method="POST">
                                Search <input id="inputsearch"type="text" name="search" />
                                <input id="searchbutton" type="submit"  value="Search"/>    
                            </form>
                        </div>

                        <!----------------   Display Department Data List start   --------------->

                        <div id="doctorlist" class="switchgroup">

                            <table border="1" class="table table-bordered table-hover">
                                <tr class="active">
                                    <td>#</td>
                                    <td>Patient Name</td>
                                    <td>Age</td>
                                    <td>Gender</td>
                                    <td>Phone</td>
                                    <td>Reason Of Visit</td>
                                    <td>Blood Group</td>
                                    <td>Date Of Admit</td>
                                    <td>Room No</td>
                                    <td>Bed No</td>
                                    <td>Observed By</td>
                                    <td>Address</td>
                                    <td>Option</td>

                                </tr>


                                <c:forEach var="p" items="${listP}">
                                    <tr>
                                        <td>${p.getPatientID()}</td>
                                        <td>${p.getPatientName()}</td>
                                        <td>${p.getAge()}</td>
                                        <td>${p.getGender()}</td>
                                        <td>${p.getPhoneNumber()}</td>
                                        <td>${p.getReaOfVisit()}</td>
                                        <td>${p.getbGroup()}</td>
                                        <td>${p.getDateAdd()}</td>
                                        <td>${p.getRoom_no()}</td>
                                        <td>${p.getBed_no()}</td>
                                        <td>${p.getDoctorName()}</td>
                                        <td>${p.getAddress()}</td>
                                        <td> 
                                            <a href="adminupdatepatient?pid=${p.getPatientID()}">Edit<a></br>
                                                <a href="adminDeletePatient?did=${p.getPatientID()}">Delete<a>
                                                            </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </table>
                                                        <c:forEach begin="1" end="${a.totalPatient}" var="i">
                                                            <a href="paging?index=${i}">${i}</a>
                                                        </c:forEach>


                                                        </div>  


                                                        </div>
                                                        <!-----------  Content Menu Tab Ends   ------------>
                                                        </div>
                                                        <!-------   Content Area Ends  --------->
                                                        </div>
                                                        <script src="js/bootstrap.min.js"></script>
                                                        </body>
                                                        </html>