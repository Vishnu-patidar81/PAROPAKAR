<%-- 
    Document   : logout
    Created on : 30 Sept 2025, 4:06:26 pm
    Author     : Vishnu Patidar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%session.invalidate();
        response.sendRedirect("home.html");%>
    </body>
</html>
