<%-- 
    Document   : exclui-folhaponto
    Created on : 29/04/2016, 00:58:49
    Author     : kassio
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
        <%
            int codRegistroPonto = Integer.parseInt(request.getParameter("codRegistroPonto"));
        %>
    <center>
        <div>
            <form name="delRegistroPonto" method="POST" action="excluirRegistro?codRegistroPonto=<%=codRegistroPonto%>">
            <p>Você tem certeza que deseja excluir o Registro?</p>                
            <input name="btExcluir" type="submit" class="botao" value="SIM" />
            </form>            
            <form method="get" action="registrosponto.jsp">
            <input name="btExcluirn" type="submit" class="botao" value="NÃO" />
            </form>
        </div>
    </center>
    </body>
</html>
