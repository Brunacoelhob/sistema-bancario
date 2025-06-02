package br.com.estudante.bruna;

import br.com.estudante.bruna.controler.Menu;

public class App {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema do Banco BBSC...");
        Menu menu = new Menu();
        menu.executarMenu();
        System.out.println("Sistema encerrado.");
    }
}
