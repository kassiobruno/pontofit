<%-- 
    Document   : exclui-funcionario
    Created on : 17/06/2016, 18:20:29
    Author     : KASSIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagens/favicon.ico" />
        <title>PontoFit</title>
    </head>
    <body>
        <%            int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
            String nome = request.getParameter("nome");
        %>
        <div id="conteudo">
            <form name="delFuncionario" method="POST" action="excluirFunc?codFuncionario=<%=codFuncionario%>">
                <div align="center">
                    <p>Você tem certeza que deseja excluir o Funcionário <%=nome%>?</p>                
                    <input name="btExcluir" type="submit" class="botao" value="EXCLUIR" />
                </div>
            </form>
        </div>
    </body>
</html>
