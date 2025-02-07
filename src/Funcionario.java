import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
   public BigDecimal salario;
   public String funcao;

   public Funcionario (String nome, LocalDate dataNasc, BigDecimal salario, String funcao){
      super(nome, dataNasc);
      this.salario = salario;
      this.funcao = funcao;
   }

   String imprimir() { //Usado para impressão dos registros
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatar data
      return  nome +" "+ this.dataNasc.format(formatter) +" "+ this.salario +" "+ this.funcao;
   }

   public BigDecimal getSalario() {
      return salario;
   }

   public void setSalario(BigDecimal salario) {
      this.salario = salario;
   }

   public String getFuncao() {
      return funcao;
   }

   public void setFuncao(String funcao) {
      this.funcao = funcao;
   }
}
