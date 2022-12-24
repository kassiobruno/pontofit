/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.EstabelecimentoDAO;
import java.io.IOException;
import javabeans.Estabelecimento;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kassio
 */
public class ServletAdicionaEstabelecimento extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Estabelecimento\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String razaoSocial, cnpj, endereco, cidade, telefone;
        
        razaoSocial = request.getParameter("razaoSocial");
        cnpj = request.getParameter("cnpj");
        endereco = request.getParameter("endereco");
        cidade = request.getParameter("cidade");
        telefone = request.getParameter("telefone");
        
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setRazaoSocial(razaoSocial);
        estabelecimento.setCnpj(cnpj);
        estabelecimento.setEndereco(endereco);
        estabelecimento.setCidade(cidade);
        estabelecimento.setTelefone(telefone);
        
        EstabelecimentoDAO edao = new  EstabelecimentoDAO();
        edao.inserir(estabelecimento);

        response.sendRedirect("sucessoEst.jsp");
    }

    @Override
    public void destroy(){
        super.destroy();
        log("Destruindo a servlet \'Adiciona Estabelecimento\' ");
    }
}
