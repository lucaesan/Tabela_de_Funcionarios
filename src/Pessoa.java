import java.time.LocalDate;

public class Pessoa {
    public String nome;
    public LocalDate dataNasc;
    public Funcionario Func;

    public Pessoa (String nome, LocalDate dataNasc){
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setData_Nasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Funcionario getFunc() {
        return Func;
    }

    public void setFunc(Funcionario func) {
        Func = func;
    }
}
