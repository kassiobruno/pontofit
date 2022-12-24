<%-- 
    Document   : home
    Created on : 04/07/2016, 10:17:05
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
        <div>
        <div>
            <fieldset style="border:3px solid #181818;">
                <legend align="center" style="color: #DCDCDC">Nova Unidade?</legend>
                <center><h4><form method="get" action="adiciona-estabelecimento.jsp"><button type="submit" class="botao">CADASTRAR</button></form></h4></center>
            </fieldset>
        </div>
        <div>
            <fieldset style="border:3px solid #181818;">
                <legend align="center" style="color: #DCDCDC">Funcionário de Férias?</legend>
                <center><h4><form method="get" action="adiciona-ferias.jsp"><button type="submit" class="botao">REGISTRAR</button></form></h4></center>
            </fieldset>
        </div>
        <div>
            <fieldset style="border:3px solid #181818;">
                <legend align="center" style="color: #DCDCDC">Registre seu ponto</legend>
                <center><h4><form method="get" action="adiciona-registroponto.jsp"><button type="submit" class="botao">ENTRAR</button></form></h4></center>
            </fieldset>
        </div>
        <div>
            <fieldset style="border:3px solid #181818;">
                <legend align="center" style="color: #DCDCDC">Consultar Registros</legend>
                <center><h4><form method="get" action="registrosponto.jsp"><button type="submit" class="botao">BUSCAR</button></form></h4></center>
            </fieldset>
        </div>
        <div>
            <fieldset style="border:3px solid #181818;">
                <legend align="center" style="color: #DCDCDC">Férias Agendadas</legend>
                <center><h4><form method="get" action="ferias.jsp"><button type="submit" class="botao">BUSCAR</button></form></h4></center>
            </fieldset>
        </div>
        <div>
            <fieldset style="border:3px solid #181818;">
                <legend align="center" style="color: #DCDCDC">Alterar Usuários</legend>
                <center><h4><form method="get" action="logins.jsp"><button type="submit" class="botao">BUSCAR</button></form></h4></center>
            </fieldset>
        </div>
        </div>
    </body>
</html>
