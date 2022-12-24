package javabeans;

public class  Funcionario {
    
    private int codFuncionario;
    private String matricula;
    private String nome;
    private String cpf;
    private String telefone;
    private String sexo;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String tipoFunc;
    private Login Login;
    private Estabelecimento Estabelecimento;

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }  
    
    public String getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(String tipoFunc) {
        this.tipoFunc = tipoFunc;
    }
        
    public Login getLogin() {
        return Login;
    }

    public void setLogin(Login Login) {
        this.Login = Login;
    }
    
    public Estabelecimento getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento Estabelecimento) {
        this.Estabelecimento = Estabelecimento;
    }
    
    public Funcionario() {        
    }
    
    public Funcionario(int codFuncionario, String matricula, String nome, String cpf, String telefone,
            String sexo, String endereco, String cidade, String uf, String cep, String tipoFunc, Login Login, 
            Estabelecimento Estabelecimento) {
        this.codFuncionario=codFuncionario;
        this.matricula=matricula;
        this.nome=nome;
        this.cpf=cpf;
        this.telefone=telefone;
        this.sexo=sexo;
        this.endereco=endereco;
        this.cidade=cidade;
        this.uf=uf;
        this.cep=cep;
        this.tipoFunc=tipoFunc;
        this.Login=Login;
        this.Estabelecimento=Estabelecimento;
    }

}
