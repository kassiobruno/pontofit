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
    <center>
        <h3>Cadastro de Usuário</h3>
        <form name="cadUsuario" method="POST" action="adicionarLog">
            <table>
                <tr>
                    <td>USUÁRIO</td>
                    <td colspan="3"><input name="usuario" type="text" maxlength="15" size="60" required/></td>
                </tr>
                <tr>
                    <td>SENHA:</td>
                    <td><input name="senha" type="password" maxlength="8" size="12" required/></td>
                    <td>CONFIRME A SENHA:</td>
                    <td><input name="confsenha" type="password" maxlength="8" size="16" required/></td>
                </tr>
                <tr align="center">
                    <td colspan="2" >
                        <input name="btLimpar" type="reset" class="botao" value="LIMPAR" />
                        <input name="btEnviar" type="submit" class="botao" id="submit" value="ENVIAR"/></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
