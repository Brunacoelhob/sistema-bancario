package br.com.estudante.bruna.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private int numeroConta;
    private String agencia = "2808-XX";
    private String password, confirmPassword;
    private double saldo = 0;
    private Cliente cliente;

    // Lista compartilhada entre todas as contas
    private static List<Conta> listContas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void gerarConta(Cliente cliente) {
        System.out.println("Gerando conta:");
        numeroConta = (int) (Math.random() * 10000);

        System.out.print("Informe uma senha: ");
        password = scanner.nextLine();

        do {
            System.out.print("Confirme a senha: ");
            confirmPassword = scanner.nextLine();

            if (!password.equals(confirmPassword)) {
                System.out.println("Revise a senha!");
            }
        } while (!password.equals(confirmPassword));

        this.cliente = cliente;
    }

    public void criarConta(Cliente referenciaCliente) {
        Cliente novoCliente = new Cliente();
        long cpfCliente = novoCliente.cadastrarCliente();

        Cliente.adicionarClientes(novoCliente);  // Lista agora é estática

        Conta novaConta = new Conta();
        Cliente clienteDaConta = Cliente.pesquisarCliente(cpfCliente);

        novaConta.gerarConta(clienteDaConta);
        adicionarList(novaConta);
    }

    public void realizarSaque(double valor) {
        if (avaliarSaque(valor)) {
            this.saldo -= valor;
        } else {
            System.out.println("Impossível realizar saque. Saldo insuficiente.");
        }
        System.out.println("O saldo disponível na conta é: " + this.saldo);
    }

    public boolean avaliarSaque(double valor) {
        return this.saldo >= valor;
    }

    public void realizarDeposito(double valor) {
        this.saldo += valor;
        System.out.println("O saldo disponível na conta é: " + this.saldo);
    }

    public void consultarSaldo() {
        System.out.println("O saldo disponível na conta é: " + this.saldo);
    }

    public void transferir(Conta contaCliente) {
        System.out.print("Informe o CPF do destinatário: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        Cliente clienteDestinatario = Cliente.pesquisarCliente(cpf);
        Conta contaDestinatario = pesquisarConta(clienteDestinatario);

        if (contaDestinatario != null) {
            System.out.println("Transferência para o usuário " + clienteDestinatario.getNome());
            System.out.print("Informe o valor: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            if (contaCliente.saldo >= valor) {
                System.out.println("Transferência realizada com sucesso!");
                System.out.println("Comprovante:");
                System.out.println("Agência: " + contaCliente.getAgencia());
                System.out.println("Conta: " + contaCliente.getNumeroConta());
                System.out.println("Remetente: " + contaCliente.cliente.getNome());
                System.out.println("CPF do remetente: " + contaCliente.cliente.getCpf());
                System.out.println("Valor: " + valor);
                System.out.println("Agência: " + contaDestinatario.getAgencia());
                System.out.println("Conta: " + contaDestinatario.getNumeroConta());
                System.out.println("Destinatário: " + contaDestinatario.cliente.getNome());
                System.out.println("CPF do destinatário: " + contaDestinatario.cliente.getCpf());

                contaCliente.saldo -= valor;
                contaDestinatario.saldo += valor;
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("CPF do destinatário não encontrado!");
        }
    }

    public void adicionarList(Conta conta) {
        listContas.add(conta);
    }

    public Conta pesquisarConta(Cliente cliente) {
        for (Conta conta : listContas) {
            if (cliente == conta.cliente) {
                return conta;
            }
        }
        return null;
    }

    public void exibirPerfil(Conta conta) {
        System.out.println("Olá, " + conta.cliente.getNome() + " !");
        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("Conta: " + conta.getNumeroConta());
    }

    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getPassword() {
        return password;
    }
}
