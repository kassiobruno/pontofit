package javabeans;


public class Ferias {
    
    private int codFerias;
    private String dataInicio;
    private String dataFim;
    private String dataPagamento;
    private String mes;
    private Funcionario funcionario;

    public int getCodFerias() {
        return codFerias;
    }

    public void setCodFerias(int codFerias) {
        this.codFerias = codFerias;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
        public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
        
    public Ferias() {    
    }
    
    public Ferias(int codFerias, String dataInicio, String dataFim, String dataPagamento, String mes, Funcionario funcionario) {
        this.codFerias=codFerias;
        this.dataInicio=dataInicio;
        this.dataFim=dataFim;
        this.dataFim=dataPagamento;
        this.mes=mes;
        this.funcionario=funcionario;

    }   
    
}
