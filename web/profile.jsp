<%-- 
    Document   : profile
    Created on : 30 Sept 2025, 3:50:14 pm
    Author     : Vishnu Patidar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <a href="logout.jsp">SignOut</a>
        <% 
    String Email = (String)session.getAttribute("Email");
    if(Email != null && !Email.trim().isEmpty()) { 
%>
        <h1> Welcome <%= Email %>...! User</h1>
<% 
    } else { 
        response.sendRedirect("LoginChecker"); 
    } 
%>

            
    </body>
</html>
