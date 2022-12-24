package javabeans;


public class RegistroPonto {
    
    private int codRegistroPonto;
    private String entrada;
    private String saida;
    private String data;
    private String intervalo;
    private String horasTrab;
    private String horaExtra;
    private Funcionario funcionario;

    public int getCodRegistroPonto() {
        return codRegistroPonto;
    }

    public void setCodRegistroPonto(int codRegistroPonto) {
        this.codRegistroPonto = codRegistroPonto;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }
    
    public String getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(String horasTrab) {
        this.horasTrab = horasTrab;
    }

    public String getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(String horaExtra) {
        this.horaExtra = horaExtra;
    }  
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
        
    public RegistroPonto() {
    }

    public RegistroPonto(int codRegistroPonto, String entrada, String saida, String data, String intervalo, String horasTrab, String horaExtra, Funcionario funcionario) {
        this.codRegistroPonto = codRegistroPonto;
        this.entrada = entrada;
        this.saida = saida;
        this.data = data;
        this.intervalo = intervalo;
        this.horasTrab = horasTrab;
        this.horaExtra = horaExtra;
        this.funcionario = funcionario;
    }
   
}
