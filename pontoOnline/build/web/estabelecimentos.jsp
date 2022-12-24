<%-- 
    Document   : estabelecimentos
    Created on : 17/06/2016, 19:30:02
    Author     : KASSIO
--%>

<%@page import="pacoteDAO.EstabelecimentoDAO"%>
<%@page import="java.util.List"%>
<%@page import="javabeans.Estabelecimento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagens/favicon.ico" />
        <title>PontoFit</title>
    </head>
    <body>
    <center>
        <div>
            <table class="tabela">
                <tr>
                    <th>RAZÃO SOCIAL</th>
                    <th>CNPJ</th>
                    <th>ENDEREÇO</th>
                    <th>CIDADE</th>
                    <th>TELEFONE</th>
                    <th>EDITAR</th>
                    <th>EXCLUIR</th>
                </tr>
                <jsp:useBean id="pacoteDAO" class="pacoteDAO.EstabelecimentoDAO" />                
                <c:forEach var="estabelecimento" items="${pacoteDAO.lista}" varStatus="id">                
                    <tr>
                        <td>${estabelecimento.razaoSocial}</td>
                        <td>${estabelecimento.cnpj}</td>
                        <td>${estabelecimento.endereco}</td>
                        <td>${estabelecimento.cidade}</td>
                        <td>${estabelecimento.telefone}</td>
                        <td>
                            <a href="altera-estabelecimento.jsp?codEstabelecimento=${estabelecimento.codEstabelecimento }&razaoSocial=${estabelecimento.razaoSocial}
                               &cnpj=${estabelecimento.cnpj}&endereco=${estabelecimento.endereco}&cidade=${estabelecimento.cidade}
                               &telefone=${estabelecimento.telefone}"><img src="imagens/edit.png" alt="editar"/></a>
                        </td>                        
                        <td>
                            <a href="exclui-estabelecimento.jsp?codEstabelecimento=${estabelecimento.codEstabelecimento}&razaoSocial=${estabelecimento.razaoSocial}"><img src="imagens/del.png" alt="excluir"/></a>                            
                        </td>
                    </tr>
                    </c:forEach>
                </table>                
            </div>
        </center>
    </body>
</html>

