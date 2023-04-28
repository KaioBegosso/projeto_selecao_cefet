import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
public class Secretario extends Funcionario {
    private static final double SALARIO_BASE = 7000.0;
    private static final double BENEFICIO_ANO = 1000.0;
    private static final double PERCENTUAL_BENEFICIO = 0.2;

    Secretario(String nome, LocalDate dataContratacao) {
        super(nome, "Secretario", dataContratacao);
    }

    @Override
    double calcularSalario(int mes, int ano) {
        long anosServico = ChronoUnit.YEARS.between(getDataContratacao(), LocalDate.of(ano, mes, 1));
        return SALARIO_BASE + (BENEFICIO_ANO * anosServico);
    }

    @Override
    double calcularBeneficio(int mes, int ano) {
        return calcularSalario(mes, ano) * PERCENTUAL_BENEFICIO;
    }
}