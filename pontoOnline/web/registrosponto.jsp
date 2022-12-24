<%-- 
    Document   : registrosponto
    Created on : 17/06/2016, 19:53:09
    Author     : KASSIO
--%>

<%@page import="javabeans.RegistroPonto"%>
<%@page import="java.util.List"%>
<%@page import="pacoteDAO.RegistroPontoDAO"%>
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
            <div>
                <table class="tabela">
                    <tr>
                        <th>ENTRADA</th>
                        <th>SAíDA</th>
                        <th>DATA</th>
                        <th>INTERVALO</th>
                        <th>HORA EXTRA</th>
                        <th>FUNCIONÁRIO</th>
                        <th>EDITAR</th>
                        <th>EXCLUIR</th>
                    </tr>
                    <jsp:useBean id="pacoteDAO" class="pacoteDAO.RegistroPontoDAO" />
                    <c:forEach var="registroponto" items="${pacoteDAO.lista}" varStatus="id">                 
                    <tr>
                        <td>${registroponto.entrada}</td>
                        <td>${registroponto.saida}</td>
                        <td>${registroponto.data}</td>
                        <td>${registroponto.intervalo}</td>
                        <td>${registroponto.horaExtra}</td>
                        <td>${registroponto.getFuncionario().getNome()}</td>
                        <td>
                            <a href="altera-registroponto.jsp?codRegistroPonto=${registroponto.codRegistroPonto }
                               "><img src="imagens/edit.png" alt="editar"/></a>
                        </td>                        
                        <td>
                            <a href="exclui-registroponto.jsp?codRegistroPonto=${registroponto.codRegistroPonto}"><img src="imagens/del.png" alt="excluir"/></a>                            
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
            <script>
            </script>    
        </center>
</body>
</html>
