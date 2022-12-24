<%-- 
    Document   : adiciona-registroPonto
    Created on : 17/06/2016, 16:20:29
    Author     : KASSIO
--%>
<%@page import="javabeans.RegistroPonto"%>
<%@page import="pacoteDAO.RegistroPontoDAO"%>
<%@page import="java.util.List"%>
<%@page import="javabeans.Funcionario"%>
<%@page import="pacoteDAO.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%
            int codRegistroPonto = Integer.parseInt(request.getParameter("codRegistroPonto"));    
            RegistroPontoDAO rdao = new RegistroPontoDAO();
            RegistroPonto regponto = rdao.consultarCodigo(codRegistroPonto);
        %>
            <center>
                <form name="altRegistroPonto" method="POST" action="alterarRegistro?codRegistroPonto=<%=codRegistroPonto %>">
                    <table>
                        <tr>
                            <td>ENTRADA:</td>
                            <td><input name="entrada" type="text" size="15" value="<%=regponto.getEntrada() %>" readonly="readonly"/></td>
                        </tr>
                        <tr>
                            <td>SAÍDA:</td>
                            <td><input name="saida" type="text" size="15" value="<%=regponto.getSaida()%>" readonly="readonly"/></td>
                        </tr>
                        <tr>
                            <td>DATA:</td>
                            <td><input name="data" type="date" size="20" value="<%=regponto.getData() %>"/></td>
                        </tr>                        
                        <tr>
                            <td>INTERVALO:</td>
                            <td><input name="intervalo" type="time" size="20" value="<%=regponto.getIntervalo() %>"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input name="horasTrab" style="display:none" type="text" size="20" value="<%=regponto.getHorasTrab() %>"/></td>
                        </tr>
                        <tr>
                            <td>HORA EXTRA:</td>
                            <td><input name="horaExtra" type="time" size="20" value="<%=regponto.getHoraExtra() %>"/></td>
                        </tr>
                        <tr>
                            <td>FUNCIONÁRIO:</td>
                            <td colspan="3" >
                                <select name="Funcionario_codFuncionario" size="1" value="<%=regponto.getFuncionario().getCodFuncionario() %>">                                   
                                    <%
                                        try{
                                            FuncionarioDAO funcDAO = new FuncionarioDAO();
                                            List<Funcionario> listaFunc =  funcDAO.getLista();
                                            for(Funcionario f: listaFunc){
                                                out.print("<option value='"+f.getCodFuncionario()+"'>"+f.getNome()+"</option>");
                                            }
                                        }catch(Exception e){
                                            out.print("Erro: "+e);
                                        
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