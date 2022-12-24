package pacoteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Login;

/**
 *
 * @author amanda
 */
public class LoginDAO {

    private Login login;
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;

    public LoginDAO() {
        login = null;
        con = Conexao.getConexao();
        rs = null;
    }

    public void cadastrar(Login log) {
        login = log;
        try {
            int cod;
            sql = "select max(codLogin) from Login";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                cod = rs.getInt(1);
            } else {
                cod = -1;
            }
            cod++;
            login.setCodLogin(cod);
            sql = "INSERT INTO `login` (`codLogin`, `usuario`, `senha`, `tipo`) "
                    + "VALUES (NULL, '" + login.getUsuario() + "', '" + login.getSenha() + "', '" + login.getTipo() + "');";
            pstm = con.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados: " + ex.getMessage());
        }
    }

    public void alterar(Login log) {
        login = log;
        try {
            sql = "UPDATE `login` SET `usuario`='" + login.getUsuario()
                    + "',`senha`='" + login.getSenha()
                    + "',`tipo`='" + login.getTipo()
                    + "' WHERE codLogin = " + login.getCodLogin();
            pstm = con.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        }
    }

    public boolean excluir(int codLogin) {
        try {
            sql = "delete from Login where codLogin = " + codLogin;
            pstm = con.prepareStatement(sql);
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados: " + ex.getMessage());
            return false;
        }
    }

    public Login consultarCodigo(int codLogin) {
        try {
            sql = "select * from login where codLogin = " + codLogin;
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                login = new Login(rs.getInt("codLogin"), rs.getString("usuario"), rs.getString("senha"), rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex);
        }
        return login;
    }

    public Login consultaUsuario(String usuario) {
        try {
            sql = "select * from login where usuario LIKE '%" + usuario + "%' ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                login = new Login(rs.getInt("codLogin"), rs.getString("usuario"), rs.getString("senha"), rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex);
        }
        return login;
    }

    public ArrayList getLista() {
        ArrayList<Login> array = new ArrayList<Login>();
        Login log;
        try {
            sql = "select * from login order by usuario";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                log = new Login(rs.getInt("codLogin"), rs.getString("usuario"), rs.getString("senha"), rs.getString("tipo"));
                array.add(log);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return array;
    }

        public Login validarLogin(String usuario, String senha, String tipo) {
        login = null;
        try {
            sql = "SELECT * FROM `Login` WHERE `usuario` LIKE '" + usuario
                    + "' AND `senha` LIKE '" + senha + "' AND `tipo` LIKE '"
                    + tipo + "' ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                login = new Login();
                login.setCodLogin(rs.getInt("codLogin"));
                login.setUsuario(rs.getString("usuario"));
                login.setSenha(rs.getString("senha"));
                login.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return login;
    }
}
