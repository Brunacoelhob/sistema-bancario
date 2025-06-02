package br.com.estudante.bruna.controler;

import br.com.estudante.bruna.model.Cliente;
import br.com.estudante.bruna.model.Conta;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Cliente referenciaCliente = new Cliente();
    Conta referenciaConta = new Conta();
    Login login = new Login();

    public void executarMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==========================");
            System.out.println("      Banco BBSC");
            System.out.println("  Seu dinheiro está aqui!");
            System.out.println("==========================");

            System.out.println("1 - Login");
            System.out.println("2 - Criar Conta");
            System.out.println("3 - Sair");

            System.out.print("Escolha uma opção: ");
            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {
                case 1:
                    Conta contaCliente = login.realizarLogin(referenciaConta, referenciaCliente);

                    if (contaCliente != null) {
                        contaCliente.exibirPerfil(contaCliente);
                        acessarConta(contaCliente);
                    }
                    break;

                case 2:
                    referenciaConta.criarConta(referenciaCliente);
                    break;

                case 3:
                    System.out.println("Encerrando o programa. Obrigado!");
                    exit = true;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void acessarConta(Conta conta) {
        boolean continuarMenu = true;

        while (continuarMenu) {
            System.out.println("\n=== Menu da Conta ===");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Saque");
            System.out.println("3 - Realizar Depósito");
            System.out.println("4 - Realizar Transferência");
            System.out.println("5 - Voltar");

            System.out.print("Escolha uma opção: ");
            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {
                case 1:
                    conta.consultarSaldo();
                    break;

                case 2:
                    System.out.print("Informe o valor que deseja sacar: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarSaque(valorSaque);
                    break;

                case 3:
                    System.out.print("Informe o valor que deseja depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarDeposito(valorDeposito);
                    break;

                case 4:
                    conta.transferir(conta);
                    break;

                case 5:
                    continuarMenu = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
