<%-- 
    Document   : adiciona-usuario
    Created on : 17/06/2016, 16:15:48
    Author     : KASSIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagens/favicon.ico" />
        <title>PontoFit</title>
    </head>
    <body>
        <%
            int codLogin = Integer.parseInt(request.getParameter("codLogin"));
            String usuario = request.getParameter("usuario");
        %>
    <center>
        <div id="conteudo">
            <form name="delUsuario" method="POST" action="excluirLog?codLogin=<%=codLogin%>">
            <p>Você tem certeza que deseja excluir o Usuario <%=usuario%>?</p>
            <input name="btExcluir" type="submit" class="botao" value="SIM" />
            </form>
            <form method="get" action="logins.jsp"><button type="submit" class="botao">NÃO</button></form>
        </div>
    </center>
    </body>
</html>

