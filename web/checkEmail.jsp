<%-- 
    Document   : checkEmail
    Created on : Feb 19, 2016, 10:06:27 AM
    Author     : Lorenas Orleckas D00157671
--%>

<%@page import="Business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="keywords" content="css3, transitions, menu, blur, navigation, typography, font, letters, text-shadow" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/home.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />       
        <link rel="stylesheet" type="text/css" href="css/style22.css" />
        <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>
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
                <%  if (c != null) {
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
            <section id="LoginRegisterBox">
                <h2 id="h2Form">Thank You</h2>
                <h3 >We have sent you an Email to your registered Email address. </br>
                    Please check your inbox and click on the link that will allow you to change your password. </h3> 
                <form>
                    <button formaction="login.jsp" class="btn-minimal">Login to Site</button>
                </form>
            </section>

            <div class="footer">
                <p style="color: white">&copy; 2016 LVA Movies </p>
            </div>
        </div>
    </body>
</html>
