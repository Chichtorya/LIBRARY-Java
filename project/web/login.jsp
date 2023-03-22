<%-- 
    Document   : login
    Created on : Oct 26, 2022, 12:50:33 AM
    Author     : chich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String x =  (String)request.getAttribute("error");
        
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>

        <h2 style="color:red; text-align: center" "><%   out.print(x); %></h2>
        <p style="text-align: center"><a href="index.html">Back to homepage</a>
    </body>
</html>
