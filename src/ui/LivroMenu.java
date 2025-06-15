package ui;

import model.Autor;
import model.Livro;
import service.Biblioteca;
import util.ClearConsole;

import java.util.List;
import java.util.Scanner;

public class LivroMenu {

    private final Scanner scan;
    private final Biblioteca biblioteca;

    public LivroMenu(Scanner scan) {
        this.scan = scan;
        this.biblioteca = new Biblioteca();
    }

    public void exibir() {
        int escolha = 0;
        while (escolha != 5) {
            ClearConsole.clear();
            System.out.println("=== MENU LIVROS ===");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Atualizar Livro");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Deletar Livro");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1 -> adicionarLivro();
                case 2 -> atualizarLivro();
                case 3 -> listarLivros();
                case 4 -> deletarLivro();
                case 5 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarLivro() {
        ClearConsole.clear();
        System.out.println("Adicionar novo livro:");
        System.out.print("ID do livro: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Título do livro: ");
        String titulo = scan.nextLine();

        System.out.println("\nAutores disponíveis:");
        List<Autor> autores = biblioteca.listarAutores();
        for (Autor autor : autores) {
            System.out.printf("%d - %s\n", autor.getId(), autor.getNome());
        }

        System.out.print("ID do autor do livro: ");
        int idAutor = scan.nextInt();
        scan.nextLine();

        Autor autorLivro = null;
        for (Autor autor : autores) {
            if (autor.getId() == idAutor) {
                autorLivro = autor;
                break;
            }
        }

        if (autorLivro != null) {
            biblioteca.adicionarLivro(new Livro(id, titulo, autorLivro));
            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("Autor não encontrado!");
        }

        pausar();
    }

    private void atualizarLivro() {
        ClearConsole.clear();
        listarLivros();

        System.out.print("\nDigite o ID do livro para atualizar: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Novo título do livro: ");
        String novoTitulo = scan.nextLine();

        biblioteca.atualizarLivro(id, novoTitulo);
        System.out.println("Livro atualizado com sucesso!");
        pausar();
    }

    private void listarLivros() {
        ClearConsole.clear();
        List<Livro> livros = biblioteca.ListarLivros();
        System.out.println("Lista de livros:");
        for (Livro livro : livros) {
            System.out.printf("%d - %s (Autor: %s)\n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
        }
        pausar();
    }

    private void deletarLivro() {
        ClearConsole.clear();
        listarLivros();

        System.out.print("\nDigite o ID do livro para deletar: ");
        int id = scan.nextInt();
        biblioteca.deletarLivro(id);
        System.out.println("Livro deletado com sucesso!");
        pausar();
    }

    private void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scan.nextLine();
    }
}
