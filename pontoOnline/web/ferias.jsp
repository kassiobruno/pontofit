<%--
    Document   : ferias
    Created on : 17/06/2016, 20:31:58
    Author     : KASSIO
--%>

<%@page import="javabeans.Ferias"%>
<%@page import="java.util.List"%>
<%@page import="pacoteDAO.FeriasDAO"%>
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
                        <th>DATA INÍCIO</th>
                        <th>DATA FIM</th>
                        <th>DATA DO PAGAMENTO</th>
                        <th>MÊS</th>
                        <th>FUNCIONÁRIO</th>
                        <th>EDITAR</th>
                        <th>EXCLUIR</th>
                    </tr>
                    <jsp:useBean id="pacoteDAO" class="pacoteDAO.FeriasDAO" />                
                    <c:forEach var="ferias" items="${pacoteDAO.lista}" varStatus="id">
                    <tr>
                        <td>${ferias.dataInicio}</td>
                        <td>${ferias.dataFim}</td>
                        <td>${ferias.dataPagamento}</td>
                        <td>${ferias.mes}</td>
                        <td>${ferias.getFuncionario().getNome()}</td>
                        <td>
                            <a href="altera-ferias.jsp?codFerias=${ferias.codFerias}
                               "><img src="imagens/edit.png" alt="editar"/></a>
                        </td>                        
                        <td>
                            <a href="exclui-ferias.jsp?codFerias=${ferias.codFerias}&mes=${ferias.mes}"><img src="imagens/del.png" alt="excluir"/></a>                            
                        </td>
                    </tr>
                    </c:forEach>
                </table>                
            </div>
        </center>
</body>
</html>
