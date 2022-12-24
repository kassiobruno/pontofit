<%-- 
    Document   : logout
    Created on : 17/06/2016, 18:48:26
    Author     : KASSIO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PontoFit</title>
    </head>
    <body>
        <%@include file="sessao.jspf" %>
        <h1>Tenha um bom dia! Volte logo!</h1>
        <%
            session = request.getSession();
            session.removeValue("usuario");
            session.removeValue("senha");
            response.sendRedirect("index.html");
        %>
    </body>
</html>
