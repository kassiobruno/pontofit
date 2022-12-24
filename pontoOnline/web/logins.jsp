<%-- 
    Document   : usuarios
    Created on : 17/06/2016, 20:40:54
    Author     : KASSIO
--%>

<%@page import="java.util.List"%>
<%@page import="javabeans.Login"%>
<%@page import="pacoteDAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagens/favicon.ico" />
        <title>PontoFit</title>
    </head>
    <body>
    <center>
        <table class="tabela">
            <tr>
                <th>USUÁRIO</th>
                <th>PERMISSÃO</th>
                <th>EDITAR</th>
                <th>EXCLUIR</th>
            </tr>
            <jsp:useBean id="pacoteDAO" class="pacoteDAO.LoginDAO" />                
            <c:forEach var="login" items="${pacoteDAO.lista}" varStatus="id">
                <tr>
                    <td>${login.usuario}</td>
                    <td>${login.tipo}</td>
                    <td>
                        <a href="altera-login.jsp?codLogin=${login.codLogin }&usuario=${login.usuario}&senha=${login.senha}">
                           <img src="imagens/edit.png" alt="editar"/></a>
                    </td>
                    <td>
                        <a href="exclui-login.jsp?codLogin=${login.codLogin}&usuario=${login.usuario}">
                            <img src="imagens/del.png" alt="excluir"/></a>                            
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</center>
</body>
</html>

