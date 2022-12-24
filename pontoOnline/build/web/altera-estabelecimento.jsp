<%-- 
    Document   : adiciona-estabelecimento
    Created on : 17/06/2016, 16:05:24
    Author     : KASSIO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script language="JavaScript" type="text/javascript" src="js/MascaraValidacao.js"></script> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="imagens/favicon.ico" />
        <title>PontoFit</title>
    </head>
    <body>
        <%
            int codEstabelecimento;
            String razaoSocial, cnpj, endereco, cidade, telefone;
            
            razaoSocial = request.getParameter("razaoSocial");
            cnpj = request.getParameter("cnpj");
            endereco = request.getParameter("endereco");
            cidade = request.getParameter("cidade");
            telefone = request.getParameter("telefone");            
            codEstabelecimento = Integer.parseInt(request.getParameter("codEstabelecimento"));
        %>
            <center>
                <br></br>
                <form name="altEstabelecimento" method="POST" action="alterarEst?codEstabelecimento=<%=codEstabelecimento %>">
                    <table>
                        <tr>
                            <td>RAZÃO SOCIAL:</td>
                            <td colspan="3"><input name="razaoSocial" type="text" size="30" required value="<%=razaoSocial %>"/></td>
                        </tr>
                        <tr>
                            <td>CNPJ:</td>
                            <td colspan="3"><input name="cnpj" type="text" size="30" required value="<%=cnpj %>" readonly="readonly"/></td>
                        </tr>
                        <tr>
                            <td>ENDEREÇO:</td>
                            <td colspan="3"><input name="endereco" type="text" size="30" required value="<%=endereco %>"/></td>
                        </tr>
                        <tr>
                            <td>CIDADE:</td>
                            <td colspan="3"><input name="cidade" type="text" size="30" required value="<%=cidade %>"/></td>
                        </tr>
                        <tr>
                            <td>TELEFONE:</td>
                            <td colspan="3"><input name="telefone" type="text" size="30" required value="<%=telefone %>" onKeyPress="MascaraTelefone(altEstabelecimento.telefone);" maxlength="15"/></td>
                        </tr>
                        <tr align="center">
                            <td colspan="2" >
                            <input name="btLimpar" type="reset" class="botao" value="LIMPAR" />
                            <input name="btEnviar" type="submit" class="botao" id="submit" value="ENVIAR" /></td>
                        </tr>
                    </table>
                </form>
            </center>
    </body>
</html>
