package pacoteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Ferias;
import javabeans.Funcionario;

public class FeriasDAO {
    
    private Ferias ferias;
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;

    public FeriasDAO() {
        ferias = null;
        con = Conexao.getConexao();
        rs = null;
    }
        
    
        public void inserir(Ferias fer){
        ferias = fer;
        try {
            int cod;
            sql = "SELECT MAX(`codFerias`) FROM `ferias`";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                cod = rs.getInt(1);
            } else {
                cod = -1;
            }
            cod++;
            ferias.setCodFerias(cod);
            sql = "INSERT INTO `ferias`(`dataInicio`, `dataFim`, `dataPagamento`, `mes`,"
                    + " `Funcionario_codFuncionario`) VALUES (" + "'" + ferias.getDataInicio()
                    + "', '" + ferias.getDataFim() + "', '" + ferias.getDataPagamento() + "', '"
                    + ferias.getMes() + "', '" + ferias.getFuncionario().getCodFuncionario() + "')";                    
            pstm = con.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados: " + ex.getMessage());
        }
    }
        
        public Ferias consultarCodigo(int codFerias){
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            sql = "SELECT * FROM `ferias` WHERE `codFerias` = " + codFerias;
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ferias = new Ferias();
                ferias.setCodFerias(rs.getInt("codFerias"));
                ferias.setDataInicio(rs.getString("dataInicio"));
                ferias.setDataFim(rs.getString("dataFim"));
                ferias.setDataPagamento(rs.getString("dataPagamento"));
                ferias.setMes(rs.getString("mes"));
                Funcionario func = fdao.consultarCodigo(rs.getInt("Funcionario_codFuncionario"));
                ferias.setFuncionario(func);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return ferias;
    }
        
        public ArrayList getLista(){
        ArrayList<Ferias> feriass = new ArrayList<>();
        FuncionarioDAO fdao = new FuncionarioDAO();
        try {
            sql = "SELECT * FROM `ferias` ORDER BY `codFerias` ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ferias = new Ferias();
                ferias.setCodFerias(rs.getInt("codFerias"));
                ferias.setDataInicio(rs.getString("dataInicio"));
                ferias.setDataFim(rs.getString("dataFim"));
                ferias.setDataPagamento(rs.getString("dataPagamento"));
                ferias.setMes(rs.getString("mes"));
                Funcionario func = fdao.consultarCodigo(rs.getInt("Funcionario_codFuncionario"));
                ferias.setFuncionario(func);
                
                feriass.add(ferias);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return feriass;
    }
        
        public void alterar(Ferias fer) throws SQLException{        
        sql = "UPDATE `ferias` SET `dataInicio` = '" + fer.getDataInicio() + "', `dataFim` = '"
                + fer.getDataFim() + "', `dataPagamento` = '" + fer.getDataPagamento() + "', `mes` = '"
                + fer.getMes() 
                + "' WHERE `codFerias` = " + fer.getCodFerias() + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
    
    public void excluir(int codFerias) throws SQLException{
        sql = "DELETE FROM `ferias` WHERE `codFerias` = " + codFerias + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
        
}