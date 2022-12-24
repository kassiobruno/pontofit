/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.RegistroPontoDAO;
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
public class ServletExcluiRegistroPonto extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui RegistroPonto\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           int codRegistroPonto = Integer.parseInt(request.getParameter("codRegistroPonto"));
           RegistroPontoDAO dao = new RegistroPontoDAO();
           dao.excluir(codRegistroPonto);
            System.out.println("RegistroPonto de codRegistroPonto" + codRegistroPonto + "excluído com sucesso.");
           response.sendRedirect("registrosponto.jsp");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Registro. " + ex);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui RegistroPonto\' ");
    }
}