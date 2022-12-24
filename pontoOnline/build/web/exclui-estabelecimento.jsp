<%-- 
    Document   : exclui-estabelecimento
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
        <%  int codEstabelecimento = Integer.parseInt(request.getParameter("codEstabelecimento"));
            String razaoSocial = request.getParameter("razaoSocial");
        %>
    <center>
        <div id="conteudo">
            <form name="delEstabelecimento" method="POST" action="excluirEst?codEstabelecimento=<%=codEstabelecimento%>">
            <p>Você tem certeza que deseja excluir o Estabelecimento <%=razaoSocial%>?</p>
            <input name="btExcluir" type="submit" class="botao" value="SIM" />
            </form>            
            <form method="get" action="estabelecimentos.jsp"><button type="submit" class="botao">NÃO</button></form>
        </div>
    </center>
</body>
</html>