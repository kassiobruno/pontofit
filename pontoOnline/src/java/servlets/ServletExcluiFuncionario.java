/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.FuncionarioDAO;
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
public class ServletExcluiFuncionario extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Exclui Funcionario\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
           FuncionarioDAO dao = new FuncionarioDAO();
           dao.excluir(codFuncionario);
            System.out.println("Funcionario de codFuncionario" + codFuncionario + "excluído com sucesso.");
           response.sendRedirect("funcionarios.jsp");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Funcionario. " + ex);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Exclui Funcionario\' ");
    }
}
