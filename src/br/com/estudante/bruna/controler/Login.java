package br.com.estudante.bruna.controler;

import br.com.estudante.bruna.model.Cliente;
import br.com.estudante.bruna.model.Conta;

import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);

    public Conta realizarLogin(Conta referenciaConta, Cliente referenciaCliente) {
        System.out.print("Informe o CPF: ");
        long cpfUser = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Informe a senha: ");
        String passwordUser = scanner.nextLine();

        Conta contaCliente = validarLogin(cpfUser, passwordUser, referenciaConta);

        if (contaCliente != null) {
            return contaCliente;
        } else {
            System.out.println("Dados incorretos. Verifique novamente ou abra uma conta.");
        }
        return null;
    }

    public Conta validarLogin(Long cpfUser, String passwordUser, Conta referenciaConta) {
        Cliente dadosCliente = Cliente.pesquisarCliente(cpfUser);

        if (dadosCliente != null) {
            Conta contaCliente = referenciaConta.pesquisarConta(dadosCliente);
            if (contaCliente != null && contaCliente.getPassword().equals(passwordUser)) {
                return contaCliente;
            }
        }
        return null;
    }
}
