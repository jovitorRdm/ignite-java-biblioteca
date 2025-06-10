package ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Autor;
import service.Biblioteca;
import util.ClearConsole;

public class Menu {

    private final Scanner scan;
    private final Biblioteca biblioteca;

    public Menu() {
        scan = new Scanner(System.in);
        biblioteca = new Biblioteca();
    }

    public void exibir() {
        int escolha = 0;
        while (escolha != 9) {
            ClearConsole.clear();
            System.out.println("=========================================");
            System.out.println("|      FUNCIONALIDADES - BIBLIOTECA     |");
            System.out.println("=========================================");
            System.out.println("| 1. Adicionar autor        -> digite 1 |");
            System.out.println("| 2. Atualizar autor        -> digite 2 |");
            System.out.println("| 3. Listar autores         -> digite 3 |");
            System.out.println("| 4. Excluir autor          -> digite 4 |");
            System.out.println("| 9. Sair                   -> digite 9 |");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1 -> adicionarAutor();
                case 2 -> atualizarAutor();
                case 3 -> listarAutores();
                case 4 -> deletarAutor();
            }
        }
    }

    private void adicionarAutor() {
        ClearConsole.clear();
        System.out.println("-------ADICIONANDO-AUTOR-------\n");
        System.out.print("Digite o id do autor: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite o nome do autor: ");
        String nome = scan.nextLine();

        biblioteca.adicionarAutor(new Autor(id, nome, new Date()));

        System.out.println("\n----ADICIONADO COM SUCESSO----");
        pausar();
    }

    private void atualizarAutor() {
        ClearConsole.clear();
        System.out.println("-------EDITANDO-AUTOR-------\n");
        System.out.print("Digite o id do autor: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite o novo nome: ");
        String nome = scan.nextLine();

        biblioteca.atualizarAutor(id, nome);

        System.out.println("\n----EDITADO COM SUCESSO----");
        pausar();
    }

    private void listarAutores() {
        ClearConsole.clear();
        List<Autor> autores = biblioteca.ListarAutores();
        System.out.println("-------LISTANDO-AUTORES-------\n");

        for (Autor autor : autores) {
            System.out.printf("%d %s\n", autor.getId(), autor.getNome());
        }

        System.out.println("\n----LISTADO COM SUCESSO----");
        pausar();
    }

    private void deletarAutor() {
        ClearConsole.clear();
        System.out.println("-------EXCLUINDO-AUTOR-------\n");
        System.out.print("Digite o id do autor: ");
        int id = scan.nextInt();

        biblioteca.deletarAutor(id);

        System.out.println("\n----EXCLUÍDO COM SUCESSO----");
        pausar();
    }

    private void pausar() {
        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine();
    }
}
