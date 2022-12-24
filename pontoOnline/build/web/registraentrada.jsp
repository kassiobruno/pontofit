<%-- 
    Document   : adiciona-folhaponto
    Created on : 17/06/2016, 16:20:29
    Author     : KASSIO
--%>

<%@page import="java.util.List"%>
<%@page import="javabeans.Funcionario"%>
<%@page import="pacoteDAO.FuncionarioDAO"%>

<center>
    <form name="cadRegistroPonto" method="POST" action="inserirEntrada">
        <table>
            <tr>
                <td>ENTRADA:</td>
                <td><input id="data" name="entrada" type="text" size="15" value="<%=data%>" readonly="readonly"/>
            </tr>
            <tr>
                <td></td>
                <td><input id="data" name="saida" style="display:none" type="text" size="15" value="" readonly="readonly"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input name="data" style="display:none" value="" type="date" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="data" name="intervalo" style="display:none" type="text" size="15" value="" readonly="readonly"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="data" name="horasTrab" style="display:none" type="text" size="15" value="" readonly="readonly"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="data" name="horaExtra" style="display:none" type="text" size="15" value="" readonly="readonly"/></td>
            </tr>
            <tr>
                <td>FUNCIONÁRIO:</td>
                <td colspan="3" >
                    <select name="Funcionario_codFuncionario" size="1" >
                        <option>Selecione...</option>
                        <%
                            try {
                                FuncionarioDAO funcDAO = new FuncionarioDAO();
                                List<Funcionario> listaFunc = funcDAO.getLista();
                                for (Funcionario f : listaFunc) {
                                    out.print("<option value='" + f.getCodFuncionario() + "'>" + f.getNome() + "</option>");
                                }
                            } catch (Exception e) {
                                out.print("Erro: " + e);

                            }

                        %>
                    </select>                            
                </td>
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


