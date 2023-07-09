<%@page contentType="text/html" import="model.*,java.util.*" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id ="d" class="model.doctor.DoctorDAO" scope="request"></jsp:useBean>

    <!DOCTYPE html>

    <html lang="en">
    <%@include file="includes/header_admin.jsp"%>
    <body>


        <div class="row">

            <%@include file="includes/menu_admin.jsp"%>

            <!-------   Content Area start  --------->
            <div class="col-md-10 maincontent" >

                <!-----------  Content Menu Tab Start   ------------>
                <div class="panel panel-default contentinside">
                    <div class="panel-heading">Manage All Doctor</div>

                    <!----------------   Panel Body Start   --------------->
                    <div class="panel-body">
                        <ul class="nav nav-tabs doctor">
                            <li role="presentation"><a href="DoctorPaging">Doctor List</a></li>
                            <li role="presentation"><a href="addDoctor.jsp">Add Doctor</a></li>
                        </ul>
                        
                        <div class="formsearch">
                            <form action="SearchDoctorController" method="POST">
                                Search <input id="inputsearch"type="text" name="search" />
                                <input id="searchbutton" type="submit"  value="Search"/>    
                            </form>
                        </div>

                        <!----------------   Display Department Data List start   --------------->

                        <div id="doctorlist" class="switchgroup">

                            <table border="1" class="table table-bordered table-hover">
                                <tr class="active">
                                    <td>#</td>
                                    <td>Doctor Name</td>
                                    <td>Email</td>
                                    <td>Address</td>
                                    <td>Phone</td>
                                    <td>Department</td>       
                                    <td>Option</td>

                                </tr>

                                <c:forEach var="dc" items="${doctor}" >

                                    <tr>
                                        <td>${dc.docID}</td>
                                        <td>${dc.docName}</td>
                                        <td>${dc.email}</td>
                                        <td>${dc.address}</td>
                                        <td>${dc.phoneNumber}</td>
                                        <td>${dc.departName}</td>
                                        <td> <a href="updatedoctor?pid=${dc.docID}">Edit<a></br>
                                                <a href="deletedoctor?did=${dc.docID}">Delete<a></td>

                                    </tr>
                                </c:forEach>


                            </table>
                            <c:forEach begin="1" end="${d.totalDoctor}" var="i">
                                <a href="DoctorPaging?index=${i}">${i}</a>
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