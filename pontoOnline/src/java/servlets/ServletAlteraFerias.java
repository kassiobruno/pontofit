/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.FeriasDAO;
import java.io.IOException;
import java.sql.SQLException;
import javabeans.Ferias;
import javabeans.Funcionario;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pacoteDAO.FuncionarioDAO;

/**
 *
 * @author kassio
 */
public class ServletAlteraFerias extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Altera Ferias\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            int codFuncionario, codFerias;
            String dataInicio, dataFim, dataPagamento, mes;            
            
            dataInicio = request.getParameter("dataInicio");
            dataFim = request.getParameter("dataFim");
            dataPagamento = request.getParameter("dataPagamento");
            mes = request.getParameter("mes");
            codFerias = Integer.parseInt(request.getParameter("codFerias"));
            codFuncionario = Integer.parseInt(request.getParameter("Funcionario_codFuncionario"));
            
            Ferias ferias = new Ferias();
            ferias.setCodFerias(codFerias);
            ferias.setDataInicio(dataInicio);
            ferias.setDataFim(dataFim);
            ferias.setDataPagamento(dataPagamento);
            ferias.setMes(mes);
            
            FuncionarioDAO funcdao = new FuncionarioDAO();
            Funcionario func = funcdao.consultarCodigo(codFuncionario);                   
            ferias.setFuncionario(func);
 
            FeriasDAO ferdao = new FeriasDAO();
            try {
                ferdao.alterar(ferias);
                response.sendRedirect("sucessoFer.jsp");;
            } catch (SQLException ex) {
                System.out.println("Erro ao alterar Ferias. " + ex.getMessage());
            }
    }

    @Override
    public void destroy(){
        super.destroy();
        log("Destruindo a servlet \'Altera Ferias\' ");
    }
}

