<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
                            <li role="presentation"><a href="patient_page.jsp">My Details</a></li>
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

                                <tr>
                                    <td>${p.patientID}</td>
                                    <td>${p.patientName}</td>
                                    <td>${p.age}</td>
                                    <td>${p.gender}</td>
                                    <td>${p.phoneNumber}</td>
                                    <td>${p.reaOfVisit}</td>
                                    <td>${p.bGroup}</td>
                                    <td>${p.dateAdd}</td>
                                    <td>${p.room_no}</td>
                                    <td>${p.bed_no}</td>
                                    <td>${p.doctorName}</td>
                                    <td>${p.address}</td>               

                                </tr>

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