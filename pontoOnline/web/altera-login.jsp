<%-- 
    Document   : adiciona-usuario
    Created on : 17/06/2016, 16:15:48
    Author     : KASSIO
--%>
<%@page import="javabeans.Login"%>
<%@page import="pacoteDAO.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%  
            int codLogin = Integer.parseInt(request.getParameter("codLogin"));
            LoginDAO ldao = new LoginDAO();
            Login login = ldao.consultarCodigo(codLogin);

        %>
<script language="JavaScript" type="text/javascript" src="js/validateForm.js"></script>
    <center>
        <form name="altUsuario" method="POST" action="alterarLog?codLogin=<%=codLogin%>" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td>USUÁRIO:</td>
                    <td colspan="3"><input name="usuario" type="text" maxlength="15" size="12" required value="<%=login.getUsuario()%>" onblur="checkExist()"/><span id="isE"></span></td>
                </tr>
                <tr>
                    <td>PERMISSÃO</td>
                    <td colspan="3" >
                    <%
                        String permissoes[] = {"admin", "usuario"};

                        for (String p : permissoes) {
                            if (login.getTipo().equals(p)) {
                    %>                                
                    <input name="tipo" type="radio" value="<%=p%>" checked="true"/> <%=p%> <br />
                    <% } else {%>
                    <input name="tipo" type="radio" value="<%=p%>"/> <%=p%> <br />
                    <%}
                                    }%>
                </td>
                </tr>
                <tr>
                    <td>SENHA:</td>
                    <td><input name="senha" type="password" maxlength="8" size="12" required value="<%=login.getSenha()%>"/></td>
                </tr>
                <tr>
                    <td>CONFIRME A SENHA:</td>
                    <td><input name="confsenha" type="password" maxlength="8" size="12" required value="<%=login.getSenha()%>"/></td>
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
