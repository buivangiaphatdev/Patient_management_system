
<%@page import="model.admin.Admin"%>
<!doctype html>
<% 
    Admin ad = (Admin) request.getSession().getAttribute("ADMIN");
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="images/logo.png" rel="icon"/>
        <title>Patient Management System</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <% request.setAttribute("ad", ad);%>
        <div class="container-fluid">

            <!--- Header Start -------->
            <div class="row header">

                <div class="col-md-10">
                    <h2 >Patient Management System</h3>
                </div>

                <div class="col-md-2 ">
                    <ul class="nav nav-pills ">
                        <li class="dropdown dmenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${ad.adminName}<span class="caret"></span></a>
                            <ul class="dropdown-menu ">
                                <li><a href="ChangePasswordAdmin.jsp">Change Password</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!--- Header Ends --------->
    </body>
</html>


