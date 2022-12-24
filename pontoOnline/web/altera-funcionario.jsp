<%-- 
    Document   : altera-funcionario
    Created on : 23/11/2016, 09:34:34
    Author     : Gisele Coutinho
--%>
<%@page import="javabeans.Login"%>
<%@page import="pacoteDAO.LoginDAO"%>
<%@page import="java.util.List"%>
<%@page import="javabeans.Estabelecimento"%>
<%@page import="pacoteDAO.EstabelecimentoDAO"%>
<%@page import="javabeans.Funcionario"%>
<%@page import="pacoteDAO.FuncionarioDAO"%>
<%            
    int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
    FuncionarioDAO fdao = new FuncionarioDAO();
    Funcionario funcionario = fdao.consultarCodigo(codFuncionario);
              
    LoginDAO ldao = new LoginDAO();
    int codLogin = Integer.parseInt(session.getValue("codLogin").toString());
    Login login = ldao.consultarCodigo(codLogin);
%>
<script language="JavaScript" type="text/javascript" src="js/validateForm.js"></script>
<script language="JavaScript" type="text/javascript" src="js/MascaraValidacao.js"></script>
    <div class="container">
        <form name="altFuncionario" method="POST" action="alterarFunc?codFuncionario=<%=codFuncionario%>" onsubmit="return validateForm()">
            <div class="row">
                <div class="col-25">
                <label for="matricula"> Matrícula </label>
                </div>
                <div class="col-75">
                <input name="matricula" type="text" size="30" required value="<%=funcionario.getMatricula()%>" onkeypress="return somenteNumeros(event)" readonly="readonly"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="nome"> Nome: </label>
                </div>
                <div class="col-75">
                <input name="nome" type="text" size="30" required value="<%=funcionario.getNome()%>"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="cpf"> CPF: </label>
                </div>
                <div class="col-75">
                <input name="cpf" type="text" size="30" required value="<%=funcionario.getCpf()%>" readonly="readonly"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="telefone"> Telefone: </label>
                </div>
                <div class="col-75">
                <input name="telefone" type="text" size="30" required value="<%=funcionario.getTelefone()%>" onKeyPress="MascaraTelefone(cadFuncionario.telefone);" maxlength="15"/>
                </div>
                </div>
            <div class="row"> 
                <div class="col-25">
                <label for="sexo"> Sexo :
                    <%
                        String sexos[] = {"Masculino", "Feminino"};

                        for (String s : sexos) {
                            if (funcionario.getSexo().equals(s)) {
                    %> 
		</label>
                </div>
                <div class="col-75">
                    <input name="sexo" type="radio" value="<%=s%>" checked="true"/> <%=s%>
                    <% } else {%>
                    <input name="sexo" type="radio" value="<%=s%>"/> <%=s%>
                    <%}
                                    }%>
                </div>
                </div>
            <div class="row">
                <div class="col-25"> 
                <label for="endereco"> Endereço: </label>
                </div>
                <div class="col-75">
                <input name="endereco" type="text" size="30" required value="<%=funcionario.getEndereco()%>"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="cidade"> Cidade: </label>
                </div>
                <div class="col-75">
                <input name="cidade" type="text" size="30" required value="<%=funcionario.getCidade()%>"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25">
                    <label for="uf"> UF: </label>
                    </div>
                    <div class="col-25">
                    <select name="uf" required>
                        <option disabled="true">Selecione...</option>
                        <%
                            String ufs[] = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO"};

                            for (String u : ufs) {
                                if (funcionario.getUf().equals(u)) {
                        %>
                        <option value="<%=u%>" selected="true"><%=u%></option>
                        <%
                        } else {
                        %>
                        <option value="<%=u%>"><%=u%></option>
                        <%}
                                        }%>
                    </select>
                    </div>
                </div>
            <div class="row">
                <div class="col-25">
                <label for="cep"> CEP: </label>
                </div>
                <div class="col-75">
                <input name="cep" type="text" size="30" required value="<%=funcionario.getCep()%>" onKeyPress="MascaraCep(cadFuncionario.cep);" maxlength="10" onBlur="ValidaCep(cadFuncionario.cep)"/>
                </div>
                </div>
            <div class="row">
                <div class="col-25"> 
                <label for="tipoFunc"> Cargo:</label>
		<%
                        String cargos[] = {"Gerente", "Professor", "Recepcionista"};

                        for (String c : cargos) {
                            if (funcionario.getTipoFunc().equals(c)) {
                    %>       
                </div>
                <div class="col-75">
                    <input name="tipoFunc" type="radio" value="<%=c%>" checked="true"/> <%=c%>
                    <% } else {%>
                    <input name="tipoFunc" type="radio" value="<%=c%>"/> <%=c%>
                    <%}
                                    }%>
                </div>
                </div>   
            <div class="row"> 
                <div class="col-25">
                <label for="login"></label>
                </div>
                <div class="col-75">
                <input type="hidden" name="Login_codLogin" value="<%=login.getCodLogin()%>"/>
                </div>
                </div>                    
            <div classi="row">
                <div class="col-25">
                <label for="Estabelecimento_codEstabelecimento"> Estabelecimento:</label>
                </div>
                <div class="col-75">
                    <select name="Estabelecimento_codEstabelecimento" size="1" required value="<%=funcionario.getEstabelecimento().getCodEstabelecimento()%>">                                   
                        <%
                            try {
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
</body>
</html>