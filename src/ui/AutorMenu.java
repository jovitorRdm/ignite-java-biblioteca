package ui;

import java.util.Scanner;
import model.Autor;
import service.Biblioteca;
import util.ClearConsole;
import java.util.Date;
import java.util.List;

public class AutorMenu {

    private final Scanner scan;
    private final Biblioteca biblioteca;

    public AutorMenu(Scanner scan) {
        this.scan = scan;
        this.biblioteca = new Biblioteca();
    }

    public void exibir() {
        int escolha = 0;
        while (escolha != 5) {
            ClearConsole.clear();
            System.out.println("=== MENU AUTORES ===");
            System.out.println("1 - Adicionar Autor");
            System.out.println("2 - Atualizar Autor");
            System.out.println("3 - Listar Autores");
            System.out.println("4 - Deletar Autor");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1 -> adicionarAutor();
                case 2 -> atualizarAutor();
                case 3 -> listarAutores();
                case 4 -> deletarAutor();
                case 5 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarAutor() {
        ClearConsole.clear();
        System.out.println("Adicionar novo autor:");
        System.out.print("ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        biblioteca.adicionarAutor(new Autor(id, nome, new Date()));
        System.out.println("Autor adicionado com sucesso!");
        pausar();
    }

    private void atualizarAutor() {
        ClearConsole.clear();
        System.out.print("ID do autor para editar: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Novo nome: ");
        String nome = scan.nextLine();
        biblioteca.atualizarAutor(id, nome);
        System.out.println("Autor atualizado com sucesso!");
        pausar();
    }

    private void listarAutores() {
        ClearConsole.clear();
        List<Autor> autores = biblioteca.listarAutores();
        System.out.println("Lista de autores:");
        for (Autor autor : autores) {
            System.out.printf("%d - %s\n", autor.getId(), autor.getNome());
        }
        pausar();
    }

    private void deletarAutor() {
        ClearConsole.clear();
        System.out.print("ID do autor para excluir: ");
        int id = scan.nextInt();
        biblioteca.deletarAutor(id);
        System.out.println("Autor excluído com sucesso!");
        pausar();
    }

    private void pausar() {
        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine();
    }
}
