import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Gerente extends Funcionario {
    Gerente(String nome, LocalDate dataContratacao) {
        super(nome, "Gerente", dataContratacao);
    }

    @Override
    double calcularSalario(int mes, int ano) {
        long anosServico = ChronoUnit.YEARS.between(getDataContratacao(), LocalDate.of(ano, mes, 1));
        return 20000 + (3000 * anosServico);
    }
}