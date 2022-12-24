/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javabeans.Estabelecimento;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pacoteDAO.EstabelecimentoDAO;

/**
 *
 * @author kassio
 */
public class ServletAlteraEstabelecimento extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Altera Estabelecimento\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            int codEstabelecimento;
            String razaoSocial, cnpj, endereco, cidade, telefone;
            
            razaoSocial = request.getParameter("razaoSocial");
            cnpj = request.getParameter("cnpj");
            endereco = request.getParameter("endereco");
            cidade = request.getParameter("cidade");
            telefone = request.getParameter("telefone");
            codEstabelecimento = Integer.parseInt(request.getParameter("codEstabelecimento"));
            
            Estabelecimento estabelecimento = new Estabelecimento();
            estabelecimento.setCodEstabelecimento(codEstabelecimento);
            estabelecimento.setRazaoSocial(razaoSocial);
            estabelecimento.setCnpj(cnpj);
            estabelecimento.setEndereco(endereco);
            estabelecimento.setCidade(cidade);
            estabelecimento.setTelefone(telefone);

            EstabelecimentoDAO edao = new  EstabelecimentoDAO();
            try {
                edao.alterar(estabelecimento);
                response.sendRedirect("estabelecimentos.jsp?codEstabelecimento="+estabelecimento.getCodEstabelecimento()+"");
            } catch (SQLException ex) {
                System.out.println("Erro ao alterar Estabelecimento. " + ex.getMessage());
            }
    }

    @Override
    public void destroy(){
        super.destroy();
        log("Destruindo a servlet \'Altera Estabelecimento\' ");
    }
}
