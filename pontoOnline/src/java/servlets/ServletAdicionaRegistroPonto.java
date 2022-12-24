/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import pacoteDAO.RegistroPontoDAO;
import java.io.IOException;
import javabeans.RegistroPonto;
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
public class ServletAdicionaRegistroPonto extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Adiciona RegistroPonto\'");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codFuncionario;
        String entrada, saida, data, intervalo, horasTrab, horaExtra;
        
        entrada = request.getParameter("entrada");
        saida = request.getParameter("saida");
        data = request.getParameter("data");
        intervalo = request.getParameter("intervalo");
        horasTrab = request.getParameter("horasTrab");
        horaExtra = request.getParameter("horaExtra");
        codFuncionario = Integer.parseInt(request.getParameter("Funcionario_codFuncionario"));
        
        RegistroPonto registroponto = new RegistroPonto();
        registroponto.setEntrada(entrada);
        registroponto.setSaida(saida);
        registroponto.setData(data);
        registroponto.setIntervalo(intervalo);
        registroponto.setHorasTrab(horasTrab);
        registroponto.setHoraExtra(horaExtra);
        
        FuncionarioDAO fdao = new FuncionarioDAO();
        Funcionario func = fdao.consultarCodigo(codFuncionario);
        registroponto.setFuncionario(func);
        
        RegistroPontoDAO regdao = new RegistroPontoDAO();
        regdao.inserir(registroponto);
        
        response.sendRedirect("sucessEntrada.html");       

    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Adiciona RegistroPonto\' ");
    }
}
