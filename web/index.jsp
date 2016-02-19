
<%@page import="Business.User"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>LVA Movies</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="keywords" content="css3, transitions, menu, blur, navigation, typography, font, letters, text-shadow" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/home.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/indexCSS.css" />
        <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>
        <script type="text/javascript" src="../js/jquery-2.2.0.min"></script>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css' />
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,400,300,600" rel="stylesheet" type="text/css">
    </head>
    <body>  
        <ul class="cb-slideshow">
            <li><span>Image 01</span></li>
            <li><span>Image 02</span></li>
            <li><span>Image 03</span></li>
            <li><span>Image 04</span></li>
            <li><span>Image 05</span></li>
            <li><span>Image 06</span></li>
        </ul>
        <%
            User c = (User) session.getAttribute("user");
        %>

        <div class="container">
            <div class="header">
                <%
                    if (c != null) {
                %> 
                <a href="#">
                    <strong>Welcome: </strong> <%=c.getFirstName()%> <%=c.getLastName()%>
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
            <div class="content">
                <ul class="bmenu">
                    <li><a href="#">Home</a></li>
                    <li><a href="shop.jsp">Shop</a></li>
                    <li><a href="#">Deals</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
            
            <div class="footer">
                <p style="color: white">&copy; 2016 LVA Movies </p>
            </div>
        </div>        
    </body>
</html>