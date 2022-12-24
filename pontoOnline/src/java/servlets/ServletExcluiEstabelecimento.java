/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.SQLException;
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
public class ServletExcluiEstabelecimento extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Estabelecimento\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

           int codEstabelecimento = Integer.parseInt(request.getParameter("codEstabelecimento"));
           
           EstabelecimentoDAO estdao = new EstabelecimentoDAO();
           try {
               estdao.excluir(codEstabelecimento);
                    System.out.println("Estabelecimento de codEstabelecimento" + codEstabelecimento + "excluído com sucesso.");
                    response.sendRedirect("estabelecimentos.jsp");
               } catch (SQLException ex) {
                    System.out.println("Erro ao excluir Estabelecimento. " + ex.getMessage());
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Estabelecimento\' ");
    }
}
