package javabeans;

public class  Estabelecimento {
    
    private int codEstabelecimento;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String telefone;

    public int getCodEstabelecimento() {
        return codEstabelecimento;
    }

    public void setCodEstabelecimento(int codEstabelecimento) {
        this.codEstabelecimento = codEstabelecimento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Estabelecimento() {
    }
    
    public Estabelecimento(int codEstabelecimento, String razaoSocial, String cnpj, String endereco, String cidade, String telefone) {
        this.codEstabelecimento=codEstabelecimento;
        this.razaoSocial=razaoSocial;
        this.cnpj=cnpj;
        this.endereco=endereco;
        this.cidade=cidade;
        this.telefone=telefone;
    }
    
    public String toString() {
        return "\n Código do Estabelecimento: " + getCodEstabelecimento() +
                "\n Razão Social: " + getRazaoSocial() +
                "\n CNPJ: " + getCnpj() +
                "\n Endereço: " + getEndereco() +
                "\n Cidade: " + getCidade() +
                "\n Telefone: " + getTelefone();     
    }
}
