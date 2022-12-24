/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.FuncionarioDAO;
import pacoteDAO.LoginDAO;
import pacoteDAO.EstabelecimentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javabeans.Estabelecimento;
import javabeans.Funcionario;
import javabeans.Login;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author kassio
 */
public class ServletAdicionaFuncionario extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Funcionario\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String matricula, nome, cpf, telefone, sexo, endereco, cidade, uf, cep, tipoFunc, usuario, senha, tipo, confsenha;
        int codEstabelecimento;
        
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
        usuario = request.getParameter("usuario");
        senha = request.getParameter("senha");
        tipo = request.getParameter("tipo");
        confsenha = request.getParameter("confsenha");
        codEstabelecimento = Integer.parseInt(request.getParameter("Estabelecimento_codEstabelecimento"));
        
        if(senha.equals(confsenha)){
            
            Funcionario funcionario = new Funcionario();
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
            
            Login login = new Login();
            login.setUsuario(usuario);
            login.setSenha(senha);
            login.setTipo(tipo);
            LoginDAO ldao = new LoginDAO();
            ldao.cadastrar(login);
            login = ldao.consultaUsuario(usuario);
            
            funcionario.setLogin(login);
            
            Estabelecimento estabelecimento = new Estabelecimento();
            estabelecimento.setCodEstabelecimento(codEstabelecimento);
            EstabelecimentoDAO edao = new EstabelecimentoDAO();
            edao.inserir(estabelecimento);
            estabelecimento = edao.consultarCodigo(codEstabelecimento);
            
            funcionario.setEstabelecimento(estabelecimento);
            
            FuncionarioDAO func;
            func = new FuncionarioDAO();
            func.inserir(funcionario);
            out.println("Inseriu Funcionario");
            System.out.println("Funcionario adicionado com sucesso.");
            response.sendRedirect("sucessoFunc.jsp");
            
        } else {
            out.println("Erro! Senhas não conferem!");
            response.sendRedirect("adiciona-funcionario.jsp");
        }

    }

    @Override
    public void destroy(){
        super.destroy();
        log("Destruindo a servlet \'Adiciona Funcionario\' ");
    }
}
