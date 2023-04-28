import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venda {
    private int mes;
    private int ano;
    private double valor;

    Venda(int mes, int ano, double valor) {
        this.mes = mes;
        this.ano = ano;
        this.valor = valor;
    }
}