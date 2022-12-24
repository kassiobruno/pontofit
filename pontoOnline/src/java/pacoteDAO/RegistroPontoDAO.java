package pacoteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.RegistroPonto;
import javabeans.Funcionario;

public class RegistroPontoDAO {

    private RegistroPonto registroponto;
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;

    public RegistroPontoDAO() {
        registroponto = null;
        con = Conexao.getConexao();
        rs = null;
    }
    
    public void inserir(RegistroPonto reg){
        registroponto = reg;
        try {
            int cod;
            sql = "SELECT MAX(`codRegistroPonto`) FROM `registroponto`";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                cod = rs.getInt(1);
            } else {
                cod = -1;
            }
            cod++;
            registroponto.setCodRegistroPonto(cod);
            sql = "INSERT INTO `registroponto`(`entrada`, `saida`, `data`, `intervalo`, "
                    + " `horasTrab`, `horaExtra`, `Funcionario_codFuncionario`) VALUES (" + "'" + registroponto.getEntrada()
                    + "', '" + registroponto.getSaida() + "', '"
                    + registroponto.getData() + "', '" + registroponto.getIntervalo() + "', '"
                    + registroponto.getHorasTrab() + "', '" + registroponto.getHoraExtra() + "', '"
                    + registroponto.getFuncionario().getCodFuncionario() + "')";
            pstm = con.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados: " + ex.getMessage());
        }
    }
    
    public RegistroPonto consultarCodigo(int codRegistroPonto){
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            sql = "SELECT * FROM `registroponto` WHERE `codRegistroPonto` = " + codRegistroPonto;
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                registroponto = new RegistroPonto();
                registroponto.setCodRegistroPonto(rs.getInt("codRegistroPonto"));
                registroponto.setEntrada(rs.getString("entrada"));
                registroponto.setSaida(rs.getString("saida"));
                registroponto.setData(rs.getString("data"));
                registroponto.setIntervalo(rs.getString("intervalo"));
                registroponto.setHorasTrab(rs.getString("horasTrab"));
                registroponto.setHoraExtra(rs.getString("horaExtra"));
                Funcionario func = fdao.consultarCodigo(rs.getInt("Funcionario_codFuncionario"));
                registroponto.setFuncionario(func);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return registroponto;
    }
    
        public ArrayList lerBusca(String busca, int codFuncionario){
        ArrayList<RegistroPonto> registrosponto = new ArrayList<>();
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            sql = "SELECT * FROM `RegistroPonto` WHERE (`data` LIKE '%" + busca 
                    + "%') AND "
                    + "`Funcionario_codFuncionario` = " + codFuncionario + " ORDER BY `data` ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                registroponto = new RegistroPonto();
                registroponto.setCodRegistroPonto(rs.getInt("codRegistroPonto"));
                registroponto.setEntrada(rs.getString("entrada"));
                registroponto.setSaida(rs.getString("saida"));
                registroponto.setData(rs.getString("data"));
                registroponto.setIntervalo(rs.getString("intervalo"));
                registroponto.setHorasTrab(rs.getString("horasTrab"));
                registroponto.setHoraExtra(rs.getString("horaExtra"));
                Funcionario func = fdao.consultarCodigo(rs.getInt("Funcionario_codFuncionario"));
                registroponto.setFuncionario(func);
                
                registrosponto.add(registroponto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return registrosponto;
    }
    
    public ArrayList getLista(){
        ArrayList<RegistroPonto> registropontos = new ArrayList<>();
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            sql = "SELECT * FROM `registroponto` ORDER BY `codRegistroPonto` ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                registroponto = new RegistroPonto();
                registroponto.setCodRegistroPonto(rs.getInt("codRegistroPonto"));
                registroponto.setEntrada(rs.getString("entrada"));
                registroponto.setSaida(rs.getString("saida"));
                registroponto.setData(rs.getString("data"));
                registroponto.setIntervalo(rs.getString("intervalo"));
                registroponto.setHorasTrab(rs.getString("horasTrab"));
                registroponto.setHoraExtra(rs.getString("horaExtra"));
                Funcionario func = fdao.consultarCodigo(rs.getInt("Funcionario_codFuncionario"));
                registroponto.setFuncionario(func);               

                registropontos.add(registroponto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return registropontos;
    }
    
    public void alterar(RegistroPonto reg) throws SQLException{        
        sql = "UPDATE `registroponto` SET `entrada` = '" + reg.getEntrada() + "', `saida` = '"
                + reg.getSaida() + "', `data` = '" + reg.getData() + "', `intervalo` = '"
                + reg.getIntervalo() + "', `horasTrab` = '" + reg.getHorasTrab() 
                + "', `horaExtra` = '" + reg.getHoraExtra()
                + "', `Funcionario_codFuncionario` = '" + reg.getFuncionario().getCodFuncionario() 
                + "' WHERE `codRegistroPonto` = " + reg.getCodRegistroPonto() + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
    
    public void excluir(int codRegistroPonto) throws SQLException{
        sql = "DELETE FROM `registroponto` WHERE `codRegistroPonto` = " + codRegistroPonto + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }    
}





/**

    public void inserir(RegistroPonto reg){
        try {
            stm.executeUpdate("INSERT INTO `pontofit`.`registroponto` "
                    + "(`entrada`, `saida`, `data`, `intervalo`, `horasTrab`, `horaExtra`, `Funcionario_codFuncionario`) "
                    + "VALUES (" + "'" + reg.getEntrada() +
                    "', '" + reg.getSaida() + "', '" + reg.getData() +
                    "', '" + reg.getIntervalo() + "', '" + reg.getHorasTrab() +
                    "', '" + reg.getHoraExtra() + "', '" + reg.getFuncionario().getCodFuncionario() + "') ");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
    }

    public void alterar(RegistroPonto folha) throws SQLException {
            try {
            String sql = "UPDATE `registroponto` SET `entrada`='" + folha.getEntrada()
                    + "',`saida`='" + folha.getSaida() + "',`data`='" + folha.getData()
                    + "',`intervalo`='" + folha.getIntervalo() + "',`horasTrab`='" + folha.getHorasTrab()
                    + "',`horaExtra`='" + folha.getHoraExtra()
                    + "',`Funcionario_codFuncionario`='" + folha.getFuncionario().getCodFuncionario()
                    + "' WHERE `codRegistroPonto`= " + folha.getCodRegistroPonto() + " ";

            System.out.println("sql: " + sql);
            stm.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }            
    }

    public void excluir(int codRegistroPonto) throws SQLException {
        try {
            stm.executeUpdate("DELETE FROM `registroponto` WHERE `codRegistroPonto`= " + codRegistroPonto + " ");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
    }

    public List<RegistroPonto> getLista() throws SQLException, ClassNotFoundException {
        ResultSet rs = stm.executeQuery("SELECT * FROM `pontofit`.`registroponto` ORDER BY `data`");
        FuncionarioDAO func = new FuncionarioDAO();
        List<RegistroPonto> registropontos = new ArrayList<RegistroPonto>();

        while (rs.next()) {
            RegistroPonto registroponto = new RegistroPonto();
            registroponto.setCodRegistroPonto(rs.getInt("codRegistroPonto"));
            registroponto.setEntrada(rs.getString("entrada"));
            registroponto.setSaida(rs.getString("saida"));
            registroponto.setData(rs.getString("data"));
            registroponto.setIntervalo(rs.getString("intervalo"));
            registroponto.setHorasTrab(rs.getString("horasTrab"));
            registroponto.setHoraExtra(rs.getString("horaExtra"));
            registroponto.setFuncionario(func.consultaCodigo(rs.getInt("Funcionario_codFuncionario")));

            registropontos.add(registroponto);
        }

        rs.close();
        return registropontos;
    }

    public RegistroPonto consultaCodigo(int codigo) throws SQLException, ClassNotFoundException {
        RegistroPonto registroponto = null;
        FuncionarioDAO func = new FuncionarioDAO();
        ResultSet rs = stm.executeQuery("SELECT * FROM `pontofit`.`registroponto` WHERE `codRegistroPonto` = " + codigo);
        while (rs.next()) {
            registroponto = new RegistroPonto();
            registroponto.setCodRegistroPonto(rs.getInt("codRegistroPonto"));
            registroponto.setEntrada(rs.getString("entrada"));
            registroponto.setSaida(rs.getString("saida"));
            registroponto.setData(rs.getString("data"));
            registroponto.setIntervalo(rs.getString("intervalo"));
            registroponto.setHorasTrab(rs.getString("horasTrab"));
            registroponto.setHoraExtra(rs.getString("horaExtra"));
            registroponto.setFuncionario(func.consultaCodigo(rs.getInt("Funcionario_codFuncionario")));
        }
        return registroponto;
    }
        public void inserirEntrada(RegistroPonto reg){
        try {
            stm.executeUpdate("INSERT INTO `pontofit`.`registroponto` "
                    + "(`entrada`, `Funcionario_codFuncionario`) "
                    + "VALUES (" + "'" + reg.getEntrada() +
                    "', '" + reg.getFuncionario().getCodFuncionario() + "') ");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
    }
}
**/
