import model.Cliente;
import model.Conta;
import repository.ContaRepository;
import java.util.Scanner;
import parser.Interpretador;
import enums.Intencao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua solicitação:");
        String pesquisa = scanner.nextLine();

        Interpretador interpretador = new Interpretador();

        Intencao intencao = interpretador.identificarIntencao(pesquisa);
        int numeroPesquisado = interpretador.extrairNumeroConta(pesquisa);

        // Clientes
        Cliente cliente1 = new Cliente("Joao", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria", "987.654.321-00");
        Cliente cliente3 = new Cliente("Pedro", "456.789.123-00");

        // Contas dos clientes
        Conta conta1 = new Conta(1001, 5000.0, cliente1);
        Conta conta2 = new Conta(1002, 3000.0, cliente2);
        Conta conta3 = new Conta(1003, 7000.0, cliente3);

        // Repositorio de contas
        ContaRepository repository = new ContaRepository();
        repository.adicionarConta(conta1);
        repository.adicionarConta(conta2);
        repository.adicionarConta(conta3);

        Conta resultado = repository.buscarPorNumero(numeroPesquisado);

        if (resultado == null) {
            System.out.println("Conta nao encontrada.");
        } else if (intencao == Intencao.CONSULTAR_SALDO) {

            System.out.println(
                    "Saldo da conta " + resultado.getNumero() +
                            ": R$ " + resultado.getSaldo());

        } else if (intencao == Intencao.CONSULTAR_CONTA) {

            System.out.println(
                    "Conta: " + resultado.getNumero() +
                            "\nCliente: " + resultado.getCliente().getNome() +
                            "\nCPF: " + resultado.getCliente().getCpf() +
                            "\nSaldo: R$ " + resultado.getSaldo());

        } else if (intencao == Intencao.CONSULTAR_EXTRATO) {

            System.out.println("Consulta de extrato ainda nao implementada.");

        } else {

            System.out.println("Nao entendi sua solicitacao.");
        }
    }
}