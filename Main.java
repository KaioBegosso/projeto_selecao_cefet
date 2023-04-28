import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Secretario jorge = new Secretario("Jorge Carvalho", LocalDate.of(2018, 1, 1));
        Secretario maria = new Secretario("Maria Souza", LocalDate.of(2015, 12, 1));
        Vendedor ana = new Vendedor("Ana Silva", LocalDate.of(2021, 12, 1));
        Vendedor joao = new Vendedor("Joao Mendes", LocalDate.of(2021, 12, 1));
        Gerente juliana = new Gerente("Juliana Alves", LocalDate.of(2017, 7, 1));
        Gerente bento = new Gerente("Bento Albino", LocalDate.of(2014, 3, 1));

        ana.adicionarVenda(new Venda(12, 2021, 5200));
        ana.adicionarVenda(new Venda(1, 2022, 4000));
        ana.adicionarVenda(new Venda(2, 2022, 4200));
        ana.adicionarVenda(new Venda(3, 2022, 5850));
        ana.adicionarVenda(new Venda(4, 2022, 7000));

        joao.adicionarVenda(new Venda(12, 2021, 3400));
        joao.adicionarVenda(new Venda(1, 2022, 7700));
        joao.adicionarVenda(new Venda(2, 2022, 5000));
        joao.adicionarVenda(new Venda(3, 2022, 5900));
        joao.adicionarVenda(new Venda(4, 2022, 6500));

        List<Funcionario> funcionarios = Arrays.asList(jorge, maria, ana, joao, juliana, bento);
        List<Funcionario> funcionariosComBeneficios = Arrays.asList(jorge, maria, ana, joao);
        List<Vendedor> vendedores = Arrays.asList(ana, joao);

        Empresa empresa = new Empresa(funcionarios);

        int mes = 4;
        int ano = 2022;

        double valorTotalPago = empresa.calcularValorTotalPago(funcionarios, mes, ano);
        System.out.println("Valor total pago (salario e beneficio): R$" + valorTotalPago);

        double totalPagoEmSalarios = empresa.calcularTotalPagoEmSalarios(funcionarios, mes, ano);
        System.out.println("Total pago em salarios: R$" + totalPagoEmSalarios);

        double totalPagoEmBeneficios = empresa.calcularTotalPagoEmBeneficios(funcionariosComBeneficios, mes, ano);
        System.out.println("Total pago em beneficios: R$" + totalPagoEmBeneficios);

        Optional<Funcionario> funcionarioComMaiorValorRecebido = empresa.getFuncionarioComMaiorValorRecebido(funcionarios, mes, ano);
        funcionarioComMaiorValorRecebido.ifPresent(funcionario -> System.out.println("Funcionario com maior valor recebido: " + funcionario.getNome()));

        empresa.getFuncionarioComMaiorBeneficioRecebido(funcionariosComBeneficios, mes, ano).ifPresent(funcionario ->
                System.out.println("Funcionario com maior beneficio recebido: " + funcionario.getNome()));

        empresa.getVendedorComMaiorVenda(vendedores, mes, ano).ifPresent(vendedor ->
                System.out.println("Vendedor com maior venda: " + vendedor.getNome()));
    }
}