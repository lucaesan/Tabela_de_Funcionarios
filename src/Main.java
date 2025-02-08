import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Alimentar lista com os dados dos funcionários
        List<Funcionario> func = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        //Impressão completa Inicial
        for (int i = 0; i < func.size(); i++){
            System.out.println(func.get(i));
        }
        System.out.println("\n");

        //Remover João
        for (int i = 0; i < func.size(); i++){
            if(func.get(i).nome == "João") {
                func.remove(i);
            }
        }

        //Impressão sem João
        for (int i = 0; i < func.size(); i++){
            System.out.println(func.get(i));
        }
        System.out.println("\n");

        //Aumento salarial 10%
        for (int i = 0; i < func.size(); i++){
            func.get(i).salario = func.get(i).salario.multiply(new BigDecimal("1.10"));
        }

        //Impressão completa com aumento salarial
        for (int i = 0; i < func.size(); i++){
            System.out.println(func.get(i));
        }

        //Impotar Arraylist de Funcionários para MAP agrupando por função
        Map<String, List<Funcionario>> funcMap = func.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Impressão do Mapa
        System.out.println("\nImpressão da lista organizada por funções");
        funcMap.forEach((funcao, colaboradores) -> {
            System.out.println(funcao + "  " + colaboradores);
        });

        //Impressão de Funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("\nOs funcionários que fazem aniversário nos meses de Outubro e Dezembro são:");
        funcMap.values().stream().flatMap(List::stream)
                .filter(f -> f.dataNasc.getMonthValue() == 10 || f.dataNasc.getMonthValue() == 12)
                .forEach(System.out::println);

        //Impressão de Funcionário com a maior idade
        System.out.println("\n");
        var maisVelho = func.stream().min(Comparator.comparing(Funcionario::getDataNasc)).get();
        var idade = ChronoUnit.YEARS.between(maisVelho.getDataNasc(), LocalDate.now());
        System.out.println(String.format("O funcionário mais velho se chama %s e possui %d anos de idade ", maisVelho.getNome(), idade));

        //Impressão de Funcionários em ordem alfabética
        System.out.println("\nLista de funcionários em ordem alfabética");
        funcMap.values().stream().flatMap(List::stream)
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        //Imprimir total dos salários dos funcionários
        BigDecimal total = funcMap.values().stream().flatMap(List::stream).map(f -> f.salario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nO total da folha de pagamento é: R$ " + Funcionario.df.format(total));

        //Imprimir quantos salários mínimos ganha cada funcionário





    }


}