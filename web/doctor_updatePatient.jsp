<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@page import="java.sql.*"%>
<html lang="en">
    <%@include file="includes/header_doctor.jsp"%>
    <body>


        <div class="row">

            <%@include file="includes/menu_doctor.jsp"%>

            <!---- Content Ares Start  -------->
            <div class="col-md-10 maincontent" >

                <!----------------   Menu Tab   --------------->
                <div class="panel panel-default contentinside">

                    <div class="panel panel-default contentinside">

                        <div class="panel panel-default contentinside">
                            <div class="panel-heading">Edit Patient Information</div>
                            <!----------------   Panel body Start   --------------->
                            <div class="panel-body">
                                <form class="form-horizontal" action="DoctorUpdatePatient" method="POST">
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Patient Id:</label>
                                        <div class="col-sm-10">
                                            
                                            <input type="number" class="form-control" name="patientID" placeholder="Patient ID" value="${listP.patientID}" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="patientname" value="${listP.patientName}" placeholder="Name" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" value="${listP.email}" placeholder="Email"  readonly="readonly">
                                        </div>
                                    </div>
                                        <div class="form-group">
                                        <label class="col-sm-2 control-label">Password</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="password" value="${listP.password}" placeholder="Password"  >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Address</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="add" value="${listP.address}" placeholder="Address" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Phone</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="phone" value="${listP.phoneNumber}" placeholder="Phone" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Health condition</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="rov" value="${listP.reaOfVisit}" placeholder="Reason Of Visit" >
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Room Number</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="roomNo" value="${listP.room_no}" placeholder="Room Number" >
                                        </div>
                                    </div>  

                                    <div class="form-group">    
                                    <label class="col-sm-2 control-label">Bed No</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" name="bedNo">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                          
                                        </select>
                                    </div>
                                </div>


                                    <div class="form-group">    
                                        <label class="col-sm-2 control-label">DocTor</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" name="doctor">
                                              <!--  <c:forEach items="${DoctorDAO.listAllDoctor()}" var="doc">
                                                    <option value="${doc.docName}">${doc.docName}</option>
                                                </c:forEach>-->
                                                <option>Bui Van Gia Phat</option>
                                                <option>Nguyen Luong Trung</option>
                                                <option>Bui Hoang Y</option>
                                                <option>Nguyen Tien Dat</option>
                                                <option>Dinh Van Toan</option>
                                                <option>Dinh Thi Cat Tuong</option>
                                            
                                                
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Gender</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="gender" value="${listP.gender}" placeholder="Gender" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Admission Date</label>
                                        <div class="col-sm-10">
                                            <input type="date" class="form-control" name="admit_date" value="${listP.dateAdd}" placeholder="Admission Date ">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">Age</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="age" value="${listP.age}" placeholder="Age" >
                                        </div>
                                    </div>
                                    <div class="form-group">    
                                    <label class="col-sm-2 control-label">Blood Group</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" name="bGroup">
                                            <option>A<sup>+</sup></option>
                                            <option>A<sup>-</sup></option>
                                            <option>B<sup>+</sup></option>
                                            <option>B<sup>-</sup></option>
                                            <option>AB<sup>+</sup></option>
                                            <option>AB<sup>-</sup></option>
                                            <option>O<sup>+</sup></option>
                                            <option>O<sup>-</sup></option>
                                        </select>
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