import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Funcionario {
    private String nome;
    private String cargo;
    private LocalDate dataContratacao;

    Funcionario(String nome, String cargo, LocalDate dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    double calcularSalario(int mes, int ano) {
        return 0.0;
    }

    double calcularBeneficio(int mes, int ano) {
        return 0.0;
    }
}