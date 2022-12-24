package pacoteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Estabelecimento;
        
public class EstabelecimentoDAO {
    private Estabelecimento estabelecimento;
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;

    public EstabelecimentoDAO() {
        estabelecimento = null;
        con = Conexao.getConexao();
        rs = null;
    }
    
        public void inserir(Estabelecimento est){
        estabelecimento = est;
        try {
            int cod;
            sql = "SELECT MAX(`codEstabelecimento`) FROM `estabelecimento`";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                cod = rs.getInt(1);
            } else {
                cod = -1;
            }
            cod++;
            estabelecimento.setCodEstabelecimento(cod);
            sql = "INSERT INTO `estabelecimento`(`razaoSocial`, `cnpj`, `endereco`, `cidade`,"
                    + " `telefone`) VALUES ('" + estabelecimento.getRazaoSocial()
                    + "', '" + estabelecimento.getCnpj() + "', '" + estabelecimento.getEndereco() + "', '"
                    + estabelecimento.getCidade() + "', '" + estabelecimento.getTelefone() + "')";
            pstm = con.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados: " + ex.getMessage());
        }      
        
    }
        public Estabelecimento consultarCodigo(int codEstabelecimento){
        try {
            sql = "SELECT * FROM `estabelecimento` WHERE `codEstabelecimento` = " + codEstabelecimento;
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                estabelecimento = new Estabelecimento();
                estabelecimento.setCodEstabelecimento(rs.getInt("codEstabelecimento"));
                estabelecimento.setRazaoSocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEndereco(rs.getString("endereco"));
                estabelecimento.setCidade(rs.getString("cidade"));
                estabelecimento.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return estabelecimento;
    }
        
        public ArrayList getLista(){
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();
        try {
            sql = "SELECT * FROM `estabelecimento` ORDER BY `codEstabelecimento` ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                estabelecimento = new Estabelecimento();
                estabelecimento.setCodEstabelecimento(rs.getInt("codEstabelecimento"));
                estabelecimento.setRazaoSocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEndereco(rs.getString("endereco"));
                estabelecimento.setCidade(rs.getString("cidade"));
                estabelecimento.setTelefone(rs.getString("telefone"));            

                estabelecimentos.add(estabelecimento);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return estabelecimentos;
    }
        
        public void alterar(Estabelecimento est) throws SQLException{        
        sql = "UPDATE `estabelecimento` SET `razaoSocial` = '" + est.getRazaoSocial() + "', `cnpj` = '"
                + est.getCnpj() + "', `endereco` = '" + est.getEndereco() + "', `cidade` = '"
                + est.getCidade() + "', `telefone` = '" + est.getTelefone()  
                + "' WHERE `codEstabelecimento` = " + est.getCodEstabelecimento() + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
    
    public void excluir(int codEstabelecimento) throws SQLException{
        sql = "DELETE FROM `estabelecimento` WHERE `codEstabelecimento` = " + codEstabelecimento + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
}