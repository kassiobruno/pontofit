<%-- 
    Document   : adiciona-ferias
    Created on : 17/06/2016, 16:34:43
    Author     : KASSIO
--%>

<%@page import="java.util.List"%>
<%@page import="javabeans.Funcionario"%>
<%@page import="pacoteDAO.FuncionarioDAO"%>
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
            <center>
                <br></br>

                <form name="cadFerias" method="POST" action="adicionarFer">
                    <table>
                        <tr>
                            <td>DATA DE INÍCIO:</td>
                            <td colspan="3"><input name="dataInicio" type="date" size="60" required/></td>
                        </tr>
                        <tr>
                            <td>DATA DO FIM:</td>
                            <td colspan="3"><input name="dataFim" type="date" size="60" required/></td>
                        </tr>
                        <tr>
                            <td>DATA DO PAGAMENTO:</td>
                            <td colspan="3"><input name="dataPagamento" type="date" required/></td>
                        </tr>
                        <tr>
                            <td>MÊS:</td>
                            <td colspan="3" ><select name="mes" size="1" required>
                                    <option>Selecione...</option> 
                                    <option value="Janeiro">Janeiro</option> 
                                    <option value="Fevereiro">Fevereiro</option> 
                                    <option value="Março">Março</option> 
                                    <option value="Abril">Abril</option> 
                                    <option value="Maio">Maio</option> 
                                    <option value="Junho">Junho</option> 
                                    <option value="Julho">Julho</option> 
                                    <option value="Agosto">Agosto</option> 
                                    <option value="Setembro">Setembro</option> 
                                    <option value="Outubro">Outubro</option> 
                                    <option value="Novembro">Novembro</option> 
                                    <option value="Dezembro">Dezembro</option>  
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>FUNCIONÁRIO:</td>
                            <td colspan="3" >
                                <select name="Funcionario_codFuncionario" size="1" required>
                                    <option>Selecione...</option>
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