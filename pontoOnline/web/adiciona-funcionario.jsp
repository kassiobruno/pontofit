<%-- 
    Document   : adiciona-funcionario
    Created on : 17/06/2016, 15:01:24
    Author     : KASSIO
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.util.List"%>
<%@page import="javabeans.Estabelecimento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pacoteDAO.EstabelecimentoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script language="JavaScript" type="text/javascript" src="js/validateForm.js"></script>
<script language="JavaScript" type="text/javascript" src="js/MascaraValidacao.js"></script> 
    <div class="container">
        <form name="cadFuncionario" method="POST" action="adicionarFunc" onsubmit="return validateForm()">
            <div class="row">
                <div class="col-25">
                <label for="matricula"> Matrícula </label>
                </div>
                <div class="col-75">
                <input name="matricula" type="text" size="30" required onkeypress="return somenteNumeros(event)"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="nome"> Nome: </label>
                </div>
                <div class="col-75">
                <input name="nome" type="text" size="30" required/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="cpf"> CPF: </label>
                </div>
                <div class="col-75">
                <input name="cpf" type="text" size="30" required onBlur="ValidarCPF(cadFuncionario.cpf);" onKeyPress="MascaraCPF(cadFuncionario.cpf);" maxlength="14"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="telefone"> Telefone: </label>
                </div>
                <div class="col-75">
                <input name="telefone" type="text" size="30" required onKeyPress="MascaraTelefone(cadFuncionario.telefone);" maxlength="15"/>
                </div>
                </div>
            <div class="row"> 
                <div class="col-25">
                <label for="sexo"> Sexo :</label>
                </div>
                <div class="col-75">
                <input name="sexo" type="radio" value="Masculino" required/> Masculino
                <input name="sexo" type="radio" value="Feminino" required/> Feminino
                </div>
                </div>
            <div class="row">
                <div class="col-25"> 
                <label for="endereco"> Endereço: </label>
                </div>
                <div class="col-75">
                <input name="endereco" type="text" size="30" required/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="cidade"> Cidade: </label>
                </div>
                <div class="col-75">
                <input name="cidade" type="text" size="30" required/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                    <label for="uf"> UF: </label>
                    </div>
                    <div class="col-25">
                    <select name="uf" size="1" required>
                            <option>Selecione...</option> 
                            <option value="AC">Acre</option> 
                            <option value="AL">Alagoas</option> 
                            <option value="AM">Amazonas</option> 
                            <option value="AP">Amapá</option> 
                            <option value="BA">Bahia</option> 
                            <option value="CE">Ceará</option> 
                            <option value="DF">Distrito Federal</option> 
                            <option value="ES">Espírito Santo</option> 
                            <option value="GO">Goiás</option> 
                            <option value="MA">Maranhão</option> 
                            <option value="MT">Mato Grosso</option> 
                            <option value="MS">Mato Grosso do Sul</option> 
                            <option value="MG">Minas Gerais</option> 
                            <option value="PA">Pará</option> 
                            <option value="PB">Paraíba</option> 
                            <option value="PR">Paraná</option> 
                            <option value="PE">Pernambuco</option> 
                            <option value="PI">Piauí</option> 
                            <option value="RJ">Rio de Janeiro</option> 
                            <option value="RN">Rio Grande do Norte</option> 
                            <option value="RO">Rondônia</option> 
                            <option value="RS">Rio Grande do Sul</option> 
                            <option value="RR">Roraima</option> 
                            <option value="SC">Santa Catarina</option> 
                            <option value="SE">Sergipe</option> 
                            <option value="SP">São Paulo</option> 
                            <option value="TO">Tocantins</option> 
                        </select>
                    </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="cep"> CEP: </label>
                </div>
                <div class="col-75">
                <input name="cep" type="text" size="30" required onKeyPress="MascaraCep(cadFuncionario.cep);" maxlength="10" onBlur="ValidaCep(cadFuncionario.cep)"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25"> 
                <label for="tipoFunc"> Cargo </label>
                </div>
                <div class="col-75">
                <input name="tipoFunc" type="radio" value="Gerente" required/> Gerente
                <input name="tipoFunc" type="radio" value="Professor" required/> Professor
                <input name="tipoFunc" type="radio" value="Recepcionista" required/> Recepcionista
                </div>
                </div>
            <div class="row"> 
                <div class="col-25">
                <label for="usuario"> Usuário: </label>
                </div>
                <div class="col-75">
                <input name="usuario" type="text" size="30" required onblur="checkExist()"/><span id="isE"></span>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="tipo"> Permissão </label>
                </div>
                <div class="col-75">
                <input name="tipo" type="radio" value="usuario" required/> Normal
                <input name="tipo" type="radio" value="admin" required/> Administrador
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="senha"> Senha: </label>
                </div>
                <div class="col-75">
                <input name="senha" type="password" size="30" required/>
                </div>
                </div>
            <div class="row">
                <div class="col-25"> 
                <label for="confsenha"> Confirme a senha: </label>
                </div>
                <div class="col-75">
                <input name="confsenha" type="password" size="30" required/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="Estabelecimento_codEstabelecimento"> Estabelecimento: </label>
                </div>
                <div class="col-75">
                        <select required name="Estabelecimento_codEstabelecimento" size="1">
                            <option>Selecione...</option>
                            <%      try {
                                    EstabelecimentoDAO estDAO = new EstabelecimentoDAO();
                                    List<Estabelecimento> listaEst = estDAO.getLista();
                                    for (Estabelecimento e : listaEst) {
                                        out.print("<option value='" + e.getCodEstabelecimento() + "'>" + e.getCidade() + "</option>");
                                    }
                                } catch (Exception e) {
                                    out.print("Erro: " + e);

                                }

                            %>
                        </select>
                </div>
                </div>
                <br/>
            <div class="row">
                <input name="btLimpar" type="reset" class="botao" value="LIMPAR" />
                <input name="btEnviar" type="submit" class="botao" id="submit" value="ENVIAR"/>
                </div>
        </form>
    </div>
    <script>
        function somenteNumeros(e) {
        var charCode = e.charCode ? e.charCode : e.keyCode;
        // charCode 8 = backspace   
        // charCode 9 = tab
        if (charCode != 8 && charCode != 9) {
            // charCode 48 equivale a 0   
            // charCode 57 equivale a 9
            if (charCode < 48 || charCode > 57) {
                return false;
            }
        }
    }
    </script>
</body>
</html>
