import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Empresa {
    private List<Funcionario> funcionarios;

    public Empresa(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public double calcularValorTotalPago(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .mapToDouble(funcionario -> funcionario.calcularSalario(mes, ano) + funcionario.calcularBeneficio(mes, ano))
                .sum();
    }

    public double calcularTotalPagoEmSalarios(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .mapToDouble(funcionario -> funcionario.calcularSalario(mes, ano))
                .sum();
    }

    public double calcularTotalPagoEmBeneficios(List<Funcionario> funcionarios, int mes, int ano) {
        if (!validarFuncionariosComBeneficios(funcionarios)) {
            throw new IllegalArgumentException("A lista de funcionarios deve conter apenas funcionarios que recebem beneficios.");
        }

        return funcionarios.stream()
                .mapToDouble(funcionario -> funcionario.calcularBeneficio(mes, ano))
                .sum();
    }

    public Optional<Funcionario> getFuncionarioComMaiorValorRecebido(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .max(Comparator.comparing(funcionario -> funcionario.calcularSalario(mes, ano) + funcionario.calcularBeneficio(mes, ano)));
    }

    public Optional<Funcionario> getFuncionarioComMaiorBeneficioRecebido(List<Funcionario> funcionarios, int mes, int ano) {
        if (!validarFuncionariosComBeneficios(funcionarios)) {
            throw new IllegalArgumentException("A lista de funcionarios deve conter apenas funcionarios que recebem beneficios.");
        }

        return funcionarios.stream()
                .max(Comparator.comparing(funcionario -> funcionario.calcularBeneficio(mes, ano)));
    }

    public Optional<Vendedor> getVendedorComMaiorVenda(List<Vendedor> vendedores, int mes, int ano) {
        return vendedores.stream()
                .max(Comparator.comparing(vendedor -> vendedor.calcularVendas(mes, ano)));
    }

    public boolean validarFuncionariosComBeneficios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .allMatch(funcionario -> funcionario instanceof Secretario || funcionario instanceof Vendedor);
    }
}