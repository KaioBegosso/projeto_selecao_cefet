import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vendedor extends Funcionario {
    private List<Venda> vendas;

    Vendedor(String nome, LocalDate dataContratacao) {
        super(nome, "Vendedor", dataContratacao);
        vendas = new ArrayList<>();
    }

    void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    double calcularVendas(int mes, int ano) {
        return vendas.stream()
                .filter(venda -> venda.getMes() == mes && venda.getAno() == ano)
                .mapToDouble(Venda::getValor)
                .sum();
    }

    @Override
    double calcularSalario(int mes, int ano) {
        long anosServico = ChronoUnit.YEARS.between(getDataContratacao(), LocalDate.of(ano, mes, 1));
        return 12000 + (1800 * anosServico);
    }

    @Override
    double calcularBeneficio(int mes, int ano) {
        return calcularVendas(mes, ano) * 0.3;
    }
}