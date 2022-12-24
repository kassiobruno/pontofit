package pacoteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static Connection getConexao() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String url = "jdbc:mysql://localhost:3306/pontofit";
            String usuario = "root";
            String senha = "";
            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver especificado não foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao Banco de Dados. " + e.getMessage());
            return null;
        }
    }
}