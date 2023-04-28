import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Gerente extends Funcionario {
    private static final double SALARIO_BASE = 20000.0;
    private static final double BENEFICIO_ANO = 3000.0;

    Gerente(String nome, LocalDate dataContratacao) {
        super(nome, "Gerente", dataContratacao);
    }

    @Override
    double calcularSalario(int mes, int ano) {
        long anosServico = ChronoUnit.YEARS.between(getDataContratacao(), LocalDate.of(ano, mes, 1));
        return SALARIO_BASE + (BENEFICIO_ANO * anosServico);
    }
}