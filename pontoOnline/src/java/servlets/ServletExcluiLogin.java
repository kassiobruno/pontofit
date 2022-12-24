/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.LoginDAO;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kassio
 */
public class ServletExcluiLogin extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Login\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codLogin = Integer.parseInt(request.getParameter("codLogin"));
        LoginDAO dao = new LoginDAO();
        dao.excluir(codLogin);
        System.out.println("Usuario de codLogin" + codLogin + "excluído com sucesso.");
        response.sendRedirect("logins.jsp");

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Login\' ");
    }
}