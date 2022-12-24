<%-- 
    Document   : funcionarios
    Created on : 17/06/2016, 18:48:26
    Author     : KASSIO
--%>

<%@page import="pacoteDAO.LoginDAO"%>
<%@page import="javabeans.Login"%>
<%@page import="javabeans.Funcionario"%>
<%@page import="pacoteDAO.FuncionarioDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagens/favicon.ico" />
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>PontoFit</title>
    </head>
    <body>
        <center>
            <div>
                <table class="tabela">
                    <tr>
                        <th>MATRÍCULA</th>
                        <th>NOME</th>
                        <th>CPF</th>
                        <th>TELEFONE</th>
                        <th>CARGO</th>
                        <th>PERMISSÃO</th>
                        <th>ESTABELECIMENTO</th>
                        <th>EDITAR</th>
                        <th>EXCLUIR</th>
                    </tr>
                    <jsp:useBean id="pacoteDAO" class="pacoteDAO.FuncionarioDAO" />                
                    <c:forEach var="funcionario" items="${pacoteDAO.lista}" varStatus="id">
                    <tr>
                        <td>${funcionario.matricula}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.telefone}</td>
                        <td>${funcionario.tipoFunc}</td>
                        <td>${funcionario.getLogin().getTipo()}</td>
                        <td>${funcionario.getEstabelecimento().getRazaoSocial()}</td>
                        <td>
                            <a href="altera-funcionario.jsp?codFuncionario=${funcionario.codFuncionario}"
                               ><img src="imagens/edit.png" alt="editar"/></a>
                        </td>                        
                        <td  >
                            <a href="exclui-funcionario.jsp?codFuncionario=${funcionario.codFuncionario}&nome=${funcionario.nome}"><img src="imagens/del.png" alt="excluir"/></a>                            
                        </td>
                    </tr>
                 </c:forEach>
                 </table>                
            </div>
        </center>
</body>
</html>
