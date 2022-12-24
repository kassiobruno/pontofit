package servlets;

import pacoteDAO.LoginDAO;
import java.io.IOException;
import javabeans.Login;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author kassio
 */
public class ValidaLoginServlet extends HttpServlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet \'Valida Login\'");
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario, senha;
        usuario = request.getParameter("usuario");
        senha = request.getParameter("senha");
        
        Login login = null;
        LoginDAO ldao = new LoginDAO();
        
        login = ldao.validarLogin(usuario, senha, "usuario");
        
        if(login == null){
            login = ldao.validarLogin(usuario, senha, "admin");
        }
                
        if(login != null) {
            HttpSession session = request.getSession(true);
            session.putValue("usuario", login.getUsuario());
            session.putValue("tipo", login.getTipo());
            session.putValue("codLogin", login.getCodLogin());
            if("usuario".equals(login.getTipo())){
                response.sendRedirect("homeuser.jsp");
            }else if("admin".equals(login.getTipo())){
                session.putValue("permissao", login.getTipo());
                response.sendRedirect("home.jsp");
            }
        }else{
            response.sendRedirect("erroLogin.html");
        }
    }
    
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet \'Valida Login\' ");
    }
}