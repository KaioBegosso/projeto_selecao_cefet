import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
public class Secretario extends Funcionario {
    Secretario(String nome, LocalDate dataContratacao) {
        super(nome, "Secretário", dataContratacao);
    }

    @Override
    double calcularSalario(int mes, int ano) {
        long anosServico = ChronoUnit.YEARS.between(getDataContratacao(), LocalDate.of(ano, mes, 1));
        return 7000 + (1000 * anosServico);
    }

    @Override
    double calcularBeneficio(int mes, int ano) {
        return calcularSalario(mes, ano) * 0.2;
    }
}