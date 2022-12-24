/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.FeriasDAO;
import pacoteDAO.FuncionarioDAO;
import java.io.IOException;
import javabeans.Ferias;
import javabeans.Funcionario;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author kassio
 */
public class ServletAdicionaFerias extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona Ferias\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        int codFuncionario;
        String dataInicio, dataFim, dataPagamento, mes;            
            
        dataInicio = request.getParameter("dataInicio");
        dataFim = request.getParameter("dataFim");
        dataPagamento = request.getParameter("dataPagamento");
        mes = request.getParameter("mes");
        codFuncionario = Integer.parseInt(request.getParameter("Funcionario_codFuncionario"));
            
        Ferias ferias = new Ferias();
        ferias.setDataInicio(dataInicio);
        ferias.setDataFim(dataFim);
        ferias.setDataPagamento(dataPagamento);
        ferias.setMes(mes);
            
        FuncionarioDAO funcdao = new FuncionarioDAO();
        Funcionario func = funcdao.consultarCodigo(codFuncionario);                   
        ferias.setFuncionario(func);
        
        FeriasDAO ferdao = new FeriasDAO();
        ferdao.inserir(ferias);
        
        response.sendRedirect("sucessoFer.jsp");                 
    }

    @Override
    public void destroy(){
        super.destroy();
        log("Destruindo a servlet \'Adiciona Ferias\' ");
    }
}

