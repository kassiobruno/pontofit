/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ServletAlteraLogin extends HttpServlet{
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Altera Login\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int codLogin;
        String usuario, senha, confsenha, tipo;
        usuario = request.getParameter("usuario");
        senha = request.getParameter("senha");
        tipo = request.getParameter("tipo");
        confsenha = request.getParameter("confsenha");
        codLogin = Integer.parseInt(request.getParameter("codLogin"));
        if (senha.equals(confsenha)) {
            Login log = new Login(codLogin, usuario, senha, tipo);
            LoginDAO lg;
            lg = new LoginDAO();
            lg.alterar(log);
            System.out.println("Login alterado com sucesso.");
            response.sendRedirect("sucessoLog.jsp");
        } else {
            out.println("Erro! Senhas não conferem!");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Altera Login\' ");
    }
}
