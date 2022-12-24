<%-- 
    Document   : altera-ferias
    Created on : 17/06/2016, 16:34:43
    Author     : KASSIO
--%>

<%@page import="javabeans.Ferias"%>
<%@page import="pacoteDAO.FeriasDAO"%>
<%@page import="java.util.List"%>
<%@page import="javabeans.Funcionario"%>
<%@page import="pacoteDAO.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%            
    int codFerias = Integer.parseInt(request.getParameter("codFerias"));
    FeriasDAO ferdao = new FeriasDAO();
    Ferias ferias = ferdao.consultarCodigo(codFerias);
%>
<center>
    <form name="altFerias" method="POST" action="alterarFer?codFerias=<%=codFerias%>">
        <table>
            <tr>
                <td>DATA DE INÍCIO:</td>
                <td colspan="3"><input name="dataInicio" type="date" value="<%=ferias.getDataInicio()%>" /></td>
            </tr>
            <tr>
                <td>DATA DO FIM:</td>
                <td colspan="3"><input name="dataFim" type="date" value="<%=ferias.getDataFim()%>" /></td>
            </tr>
            <tr>
                <td>DATA DO PAGAMENTO:</td>
                <td colspan="3"><input name="dataPagamento" type="date" value="<%=ferias.getDataPagamento()%>" /></td>
            </tr>
            <tr>
                <td>MÊS:</td>
                <td colspan="3" >
                    <select name="mes" required>
                        <option disabled="true">Selecione...</option>
                        <%
                            String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

                            for (String m : meses) {
                                if (ferias.getMes().equals(m)) {
                        %>
                        <option value="<%=m%>" selected="true"><%=m%></option>
                        <%
                        } else {
                        %>
                        <option value="<%=m%>"><%=m%></option>
                        <%}
                            }%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>FUNCIONÁRIO:</td>
                <td colspan="3" >
                    <select name="Funcionario_codFuncionario" size="1" value="<%=ferias.getFuncionario().getCodFuncionario()%>">                                   
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