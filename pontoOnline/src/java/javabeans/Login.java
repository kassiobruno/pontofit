package javabeans;

public class Login {
    private int codLogin;
    private String usuario;
    private String senha;
    private String tipo;

    public Login(int codLogin, String usuario, String senha, String tipo) {
        this.codLogin = codLogin;
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public Login() {
        
    }

    public int getCodLogin() {
        return codLogin;
    }

    public void setCodLogin(int codLogin) {
        this.codLogin = codLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo=tipo;
    }
   
    
}
