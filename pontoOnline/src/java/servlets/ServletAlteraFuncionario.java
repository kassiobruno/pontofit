/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.FuncionarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javabeans.Estabelecimento;
import javabeans.Funcionario;
import javabeans.Login;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pacoteDAO.EstabelecimentoDAO;
import pacoteDAO.LoginDAO;

/**
 *
 * @author kassio
 */
public class ServletAlteraFuncionario extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Altera Funcionario\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String matricula, nome, cpf, telefone, sexo, endereco, cidade, uf, cep, tipoFunc;
        int codEstabelecimento, codFuncionario, codLogin;

        matricula = request.getParameter("matricula");
        nome = request.getParameter("nome");
        cpf = request.getParameter("cpf");
        telefone = request.getParameter("telefone");
        sexo = request.getParameter("sexo");
        endereco = request.getParameter("endereco");
        cidade = request.getParameter("cidade");
        uf = request.getParameter("uf");
        cep = request.getParameter("cep");
        tipoFunc = request.getParameter("tipoFunc");
        codLogin = Integer.parseInt(request.getParameter("Login_codLogin"));
        codEstabelecimento = Integer.parseInt(request.getParameter("Estabelecimento_codEstabelecimento"));
        codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));

        Funcionario funcionario = new Funcionario();
        funcionario.setCodFuncionario(codFuncionario);
        funcionario.setMatricula(matricula);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setTelefone(telefone);
        funcionario.setSexo(sexo);
        funcionario.setEndereco(endereco);
        funcionario.setCidade(cidade);
        funcionario.setUf(uf);
        funcionario.setCep(cep);
        funcionario.setTipoFunc(tipoFunc);

        LoginDAO ldao = new LoginDAO();
        Login login = ldao.consultarCodigo(codLogin);
        funcionario.setLogin(login);

        EstabelecimentoDAO edao = new EstabelecimentoDAO();
        Estabelecimento est = edao.consultarCodigo(codEstabelecimento);
        funcionario.setEstabelecimento(est);

        FuncionarioDAO funcdao = new FuncionarioDAO();

        try {
            funcdao.alterar(funcionario);
            response.sendRedirect("sucessoFunc.jsp");
        } catch (SQLException ex) {
            log("Erro ao alterar! " + ex.getMessage());
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Altera Funcionario\' ");
    }
}
