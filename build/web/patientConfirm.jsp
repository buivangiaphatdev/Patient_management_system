<%@page contentType="text/html" pageEncoding="utf-8" %>
<jsp:useBean id="patients" class="model.Patient" scope="session" />
<jsp:setProperty name="patients" property="*"/>
<section>
    <h1>Sign up new patient</h1>
    <form action="registerpatient" method="post">
        <table border="0">
            <tr><td> Full Name: </td><td> ${patients.patientName} </td></tr>
            <tr><td> Gender: </td><td>${patients.gender}</td></tr>
            <tr><td> Age: </td><td>${patients.age}</td></tr>
            <tr><td> Blood Group: </td><td>${patients.getbGroup()}</td></tr>
            <tr><td> Phone Number: </td><td> ${patients.phoneNumber} </td></tr>
            <tr><td> Rea Of Visit: </td><td> ${patients.reaOfVisit} </td></tr>
            <tr><td> Email: </td><td>${patients.email}</td></tr>
            <tr><td> Password: </td><td> ${patients.password} </td></tr>
            <tr><td> Address: </td><td> ${patients.address} </td></tr>
            

        </table><hr>
        <input type="submit" value="Register" /> <input type="Button" value="Back" onclick="javascript:history.go(-1)">
    </form>
</section>




<!-- end the middle column -->

