<%-- 
    Document   : changePassword
    Created on : Feb 17, 2016, 4:28:23 PM
    Author     : Lorenas Orleckas D00157671
--%>


<%@page import="Business.User"%>
<%@page import="java.util.ArrayList"%>
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
                <h2 id="h2Form">Change Password</h2>
                <form name="loginCustomer" id="formValidation" method="post" action="UserActionServlet" class="minimal">
                    <label for="Email">
                        <p id="pForm">Email</p>
                        <input type="text" name="email" id="email" placeholder="Example@gmail.com" pattern="([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})" required="required" title="Please enter email: Example@gmail.com"/>
                    </label>
                    <label for="Password">
                        <p id="pForm">Password</p>
                        <input type="password" minlength="6" maxlength="30" name="password" id="password" placeholder="Password must contain 1 uppercase, lowercase and number" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" required="required" title="Password must contain 1 uppercase, lowercase and number"/>
                    </label>
                    <label for="Password">
                        <p id="pForm">Retype-Password</p>
                        <input type="password" minlength="6" maxlength="30" name="rpassword" id="password" placeholder="Password must contain 1 uppercase, lowercase and number" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" required="required" title="Password must contain 1 uppercase, lowercase and number"/>
                    </label>
                    <input type="hidden" name="action" value="changePassword" />
                    <button type="submit" value="changePassword" class="btn-minimal">Change</button>
                </form>
            </section>

            <div class="footer">
                <p style="color: white">&copy; 2016 LVA Movies </p>
            </div>
        </div>
    </body>
</html>

