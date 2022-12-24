/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.FeriasDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kassio
 */
public class ServletExcluiFerias extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Ferias\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           int codFerias = Integer.parseInt(request.getParameter("codFerias"));
           FeriasDAO dao = new FeriasDAO();
           dao.excluir(codFerias);
            System.out.println("Ferias de codFerias" + codFerias + "excluído com sucesso.");
           response.sendRedirect("ferias.jsp");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Ferias. " + ex);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Ferias\' ");
    }
}
