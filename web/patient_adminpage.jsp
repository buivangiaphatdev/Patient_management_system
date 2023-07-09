<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
                    <div class="panel-heading">Manage Patient</div>
                    <!----------------   Panel body Start   --------------->
                    <div class="panel-body">
                        <ul class="nav nav-tabs doctor">
                            <li role="presentation"><a href="patient_adminpage.jsp">Patient List</a></li>
                            
                        </ul>


                        <!----------------   Display Patients Data List Start  --------------->
                        <div id="doctorlist" class="switchgroup">
                            <table class="table table-bordered table-hover">
                                <tr class="active">
                                    <td>#</td>
                                    <td>Patient Name</td>
                                    <td>Age</td>
                                    <td>Sex</td>
                                    <td>Phone</td>
                                    <td>Reason Of Visit</td>
                                    <td>Blood Group</td>
                                    <td>Date Of Admit</td>
                                    <td>Room No</td>
                                    <td>Bed No</td>
                                    <td>Observed By</td>
                                    <td>Address</td>

                                </tr>
                                <c:forEach items="${list}" var="c">
                                    <tr>
                                        <td>${c.patientID}</td>
                                        <td>${c.patientName}</td>
                                        <td>${c.age}</td>
                                        <td>${c.gender}</td>
                                        <td>${c.phoneNumber}</td>
                                        <td>${c.reaOfVisit}</td>
                                        <td>${c.bGroup}</td>
                                        <td>${c.dateAdd}</td>
                                        <td>${c.room_no}</td>
                                        <td>${c.bed_no}</td>
                                        <td>${c.doctorName}</td>
                                        <td>${c.address}</td>               

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>



                        <!----------------   Add Patients Ends   --------------->
                    </div>
                    <!----------------   Panel body Ends   --------------->
                </div>
            </div>
        </div>
    </div>




    <script src="js/bootstrap.min.js"></script>
</body>
</html>