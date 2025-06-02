package br.com.estudante.bruna.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    // Encapsulamento de dados
    private String nome;
    private long cpf, rg, telefone;

    // Lista de clientes compartilhada entre todas as instâncias
    private static List<Cliente> listClientes = new ArrayList<>();

    // Scanner para entrada de dados
    Scanner scanner = new Scanner(System.in);

    // Cadastra cliente e retorna o CPF como identificador
    public long cadastrarCliente() {
        System.out.print("Informe o nome: ");
        nome = scanner.nextLine();

        System.out.print("Informe o CPF: ");
        cpf = scanner.nextLong();

        System.out.print("Informe o RG: ");
        rg = scanner.nextLong();

        System.out.print("Informe o telefone: ");
        telefone = scanner.nextLong();
        scanner.nextLine(); // Consome a quebra de linha

        return getCpf();
    }

    // Adiciona cliente na lista estática
    public static void adicionarClientes(Cliente cliente) {
        listClientes.add(cliente);
    }

    // Lista os clientes (nome + CPF)
    public static void listarClientes() {
        for (Cliente cliente : listClientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("-----------");
        }
    }

    // Pesquisa cliente na lista estática pelo CPF
    public static Cliente pesquisarCliente(long cpf) {
        for (Cliente cliente : listClientes) {
            if (cliente.getCpf() == cpf) {
                return cliente;
            }
        }
        return null;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
