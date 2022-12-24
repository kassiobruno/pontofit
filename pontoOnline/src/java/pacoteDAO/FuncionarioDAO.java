package pacoteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javabeans.Estabelecimento;
import javabeans.Funcionario;
import javabeans.Login;

public class FuncionarioDAO {
    
    private Funcionario funcionario;
    private final Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;

    public FuncionarioDAO() {
        funcionario = null;
        con = Conexao.getConexao();
        rs = null;
    }
    
    public void inserir(Funcionario func){
        funcionario = func;
        try {
            int cod;
            sql = "SELECT MAX(`codFuncionario`) FROM `funcionario`";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                cod = rs.getInt(1);
            } else {
                cod = -1;
            }
            cod++;
            funcionario.setCodFuncionario(cod);
            sql = "INSERT INTO `funcionario`(`matricula`, `nome`, `cpf`, `telefone`, `sexo`,"
                    + " `endereco`, `cidade`, `uf`, `cep`, `tipoFunc`,"
                    + " `Login_codLogin`, `Estabelecimento_codEstabelecimento`) VALUES (" + "'" + funcionario.getMatricula()
                    + "', '" + funcionario.getNome() + "', '" + funcionario.getCpf() + "', '"
                    + funcionario.getTelefone() + "', '" + funcionario.getSexo() + "', '"
                    + funcionario.getEndereco() + "', '" + funcionario.getCidade() + "', '"
                    + funcionario.getUf() + "', '" + funcionario.getCep() + "', '"
                    + funcionario.getTipoFunc() + "', '" + funcionario.getLogin().getCodLogin() + "', '"
                    + funcionario.getEstabelecimento().getCodEstabelecimento() + "')";
            pstm = con.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro no banco de dados: " + ex.getMessage());
        }
    }
    
    public Funcionario consultarCodigo(int codFuncionario){
        LoginDAO ldao = new LoginDAO();
        EstabelecimentoDAO edao = new EstabelecimentoDAO();
        try {
            sql = "SELECT * FROM `funcionario` WHERE `codFuncionario` = " + codFuncionario;
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setTipoFunc(rs.getString("tipoFunc"));
                Login login = ldao.consultarCodigo(rs.getInt("Login_codLogin"));
                funcionario.setLogin(login);
                Estabelecimento est = edao.consultarCodigo(rs.getInt("Estabelecimento_codEstabelecimento"));
                funcionario.setEstabelecimento(est);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return funcionario;
    }
    
        public Funcionario consultarNome(String nome){
        LoginDAO ldao = new LoginDAO();
        EstabelecimentoDAO edao = new EstabelecimentoDAO();
        try {
            sql = "SELECT * FROM `funcionario` WHERE `nome` = " + nome;
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setTipoFunc(rs.getString("tipoFunc"));
                Login login = ldao.consultarCodigo(rs.getInt("Login_codLogin"));
                funcionario.setLogin(login);
                Estabelecimento est = edao.consultarCodigo(rs.getInt("Estabelecimento_codEstabelecimento"));
                funcionario.setEstabelecimento(est);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return funcionario;
    }
    
    public ArrayList getLista(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        LoginDAO ldao = new LoginDAO();
        EstabelecimentoDAO edao = new EstabelecimentoDAO();
        try {
            sql = "SELECT * FROM `funcionario` ORDER BY `codFuncionario` ";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setTipoFunc(rs.getString("tipoFunc"));        
                Login login = ldao.consultarCodigo(rs.getInt("Login_codLogin"));
                funcionario.setLogin(login);
                Estabelecimento est = edao.consultarCodigo(rs.getInt("Estabelecimento_codEstabelecimento"));
                funcionario.setEstabelecimento(est);
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro no banco: " + ex.getMessage());
        }
        return funcionarios;
    }
    
    public void alterar(Funcionario func) throws SQLException{        
        sql = "UPDATE `funcionario` SET `matricula` = '" + func.getMatricula() + "', `nome` = '"
                + func.getNome() + "', `cpf` = '" + func.getCpf() + "', `telefone` = '"
                + func.getTelefone() + "', `sexo` = '" + func.getSexo() 
                + "', `endereco` = '" + func.getEndereco() + "', `cidade` = '"
                + func.getCidade() + "', `uf` = '" + func.getUf() + "', `cep` = '"
                + func.getCep() + "', `tipoFunc` = '" + func.getTipoFunc() + "', `Login_codLogin` = '"
                + func.getLogin().getCodLogin() + "', `Estabelecimento_codEstabelecimento` = '" + func.getEstabelecimento().getCodEstabelecimento()
                + "' WHERE `codFuncionario` = " + func.getCodFuncionario() + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
    
    public void excluir(int codFuncionario) throws SQLException{
        sql = "DELETE FROM `funcionario` WHERE `codFuncionario` = " + codFuncionario + " ";
        pstm = con.prepareStatement(sql);
        pstm.execute();
    }
}