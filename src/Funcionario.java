import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Funcionario extends Pessoa {
   private BigDecimal salario;
   private String funcao;

   // Formatar data
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   //Formatar Bigdecimal
   static DecimalFormat df = new DecimalFormat("#,##0.00");

   public Funcionario (String nome, LocalDate dataNasc, BigDecimal salario, String funcao){
      super(nome, dataNasc);
      this.salario = salario;
      this.funcao = funcao;
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

   //Organiza e formata as informações retornadas pelo Objeto.
   @Override
   public String toString(){
      return String.format("Nome: %s | Data de Nascimento: %s | Salário: R$ %s | Função: %s ",getNome(), getDataNasc().format(formatter), df.format(getSalario()), getFuncao());
   }

}
