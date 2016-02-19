<%-- 
    Document   : existingCustomerError
    Created on : Feb 11, 2016, 12:31:10 AM
    Author     : Lorenas Orleckas D00157671
--%>

<%@page import="Business.User"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Existing Customer Error Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/home.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="../js/jquery-2.2.0.min"></script>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css' />
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,400,300,600" rel="stylesheet" type="text/css">
    </head>
    <body>  
        <%
            User c = (User) session.getAttribute("user");
        %>

        <div class="container">
            <div class="header">
                <%
                    if (c != null) {
                %> 
                <a href="#">
                    <strong>Welcome: </strong> <%=c.getFirstName()%>
                </a>
                <% }%>
                <span class="right">
                    <%
                        if (c == null) {
                    %> 
                    <a href="register.jsp">Register</a>
                    <a href="login.jsp"><strong>Login</strong></a>
                    <%} else {%>
                    <a href="logout.jsp">Logout</a>
                    <% }%>
                    <a href="#">Cart (0)</a>
                </span>
                <div class="clr"></div>
            </div>

            <h1>LVA <span>Movies</span></h1>
            <div class="contentMeniu">
                <ul class="bmenu1">
                    <li><a href="index.jsp">Home</a></li>
                        <li><a href="shop.jsp">Shop</a></li>
                        <li><a href="#">Deals</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="container">
                <div class="center">
                    <h2>Customer with this email already exists, please choose different email address</h2>            
                    <p >Return to <a href="register.jsp"> Register </a> Page?</p>
                </div>
            </div>
            <div class="footer">
                <p style="color: white">&copy; 2016 LVA Movies </p>
            </div>
        </div>
</html>